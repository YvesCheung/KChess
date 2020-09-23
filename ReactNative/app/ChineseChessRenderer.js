import {Image} from 'react-native-canvas';
import ChineseChess from "kchess-algorithm-chinesechess"

export default class ChineseChessRenderer {

  static ROW_SIZE = ChineseChess.ChessBoard.ROW_SIZE
  static COLUMN_SIZE = ChineseChess.ChessBoard.COLUMN_SIZE

  constructor(props) {
    this.style = {
      chessBoardWidth: props.chessBoardWidth,
      chessBoardHeight: props.chessBoardHeight,
      chessBoardStart: props.chessBoardStart,
      chessBoardTop: props.chessBoardTop,
      chessmanWidth: props.chessmanWidth,
      chessmanHeight: props.chessmanHeight,
      rowGap: props.rowGap,
      columnGap: props.columnGap
    }
    this.imageUrlMap = props.imageUrlMap
    this.game = props.game
    this.controller = props.controller
    this.gameBoard = this.game.gameBoard
    this.imgResult = new Map()
    require('./util')
  }

  onCanvasReady = (ref) => {
    if (ref) {
      this.canvas = ref
      this.context = ref.getContext('2d')
      this.canvas.width = this.style.chessBoardWidth
      this.canvas.height = this.style.chessBoardHeight

      this.controller.onRenderFrame((finish) => {
        this.render()
        setTimeout(finish, 500) //enough time for render
      })
      this._downloadImage()
    }
  }

  _downloadImage = () => {
    let unFinishImageCount = this.imageUrlMap.size
    for (const [key, url] of this.imageUrlMap.entries()) {
      const image = new Image(this.canvas)
      image.src = url
      image.addEventListener('load', () => {
        this.imgResult.set(key, image)
        if (--unFinishImageCount === 0) {
          this.render()
        }
      });
      image.addEventListener('error', () => {
        if (--unFinishImageCount === 0) {
          this.render()
        }
      });
    }
  }

  render = () => {
    const width = this.style.chessmanWidth
    const height = this.style.chessmanHeight

    if (this.context && this.imgResult.size > 0) {
      const drawBufferCache = new Array(ChineseChessRenderer.ROW_SIZE)
      this.gameBoard.forEach((chessman, newLine, row, column) => {
        if (column === 0) {
          drawBufferCache[row] = new Array(ChineseChessRenderer.COLUMN_SIZE)
        }
        drawBufferCache[row][column] = []
        if (chessman) {
          const image = this.imgResult.get(chessman)
          if (image) {
            drawBufferCache[row][column].push(
              new RenderElement(this.context.drawImage, image, 0, 0, width, height)
            )

            const decorateArray = this.controller.getRenderDecorate(row, column)
            for (const decorate of decorateArray) {
              const name = ChineseChessRenderer.decorateImage[decorate]
              const decorImg = this.imgResult.get(name)
              if (decorImg) {
                drawBufferCache[row][column].push(
                  new RenderElement(this.context.drawImage, decorImg, 0, 0, width, height)
                )
              } else {
                console.error(`No Image found for ${decorate}-${name}, is it correct?`)
              }
            }
          } else {
            console.error(`No Image found for ${chessman}, did 'prepareImage' has been called?`)
          }
        }
      })

      let left = this.style.chessBoardStart
      let top = this.style.chessBoardTop
      drawBufferCache.forEach((rowElement, row) => {
        rowElement.forEach((columnElement, column) => {
          const lastElement =
            this.lastDrawCache &&
            this.lastDrawCache[row] &&
            this.lastDrawCache[row][column]
          if (!columnElement.equals(lastElement)) {
            console.log(`render position(${row}, ${column})`)
            this.context.save()
            this.context.translate(left, top)
            this.context.clearRect(0, 0, width, height)
            for (const element of columnElement) {
              element.drawOn(this.context)
            }
            this.context.restore()
          }
          left += this.style.columnGap
        })
        left = this.style.chessBoardStart
        top += this.style.rowGap
      })
      this.lastDrawCache = drawBufferCache
    }
  }

  onClick = ({nativeEvent}) => {
    if (this.context) {
      const columnIndex = Math.floor((nativeEvent.locationX - this.style.chessBoardStart) / this.style.columnGap)
      const rowIndex = Math.floor((nativeEvent.locationY - this.style.chessBoardTop) / this.style.rowGap)
      console.log(`click target row = ${rowIndex}, column = ${columnIndex}`)
      this.controller.click(rowIndex, columnIndex)
    }
  }

  static decorateImage = (() => {
    const Decorate = ChineseChess.com.github.kchess.algorithm.ChineseChessUiController.Decorate
    return {
      [Decorate.Player1From]: "targetRed",
      [Decorate.Player1To]: "targetRed",
      [Decorate.Player1Select]: "targetRed",
      [Decorate.Player2From]: "targetBlack",
      [Decorate.Player2To]: "targetBlack",
      [Decorate.Player2Select]: "targetBlack",
    }
  })()
}

export class RenderElement {
  constructor(renderFunction, ...param) {
    this.func = renderFunction
    this.param = param
  }

  equals = (other) => {
    if (other instanceof RenderElement) {
      return this.func === other.func && this.param.equals(other.param)
    }
    return false
  }

  drawOn = (context) => {
    this.func.bind(context)(...this.param)
  }
}
