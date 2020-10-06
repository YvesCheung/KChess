import ChineseChess from "kchess-algorithm-chinesechess"
import './util'

export default class ChineseChessRenderer {

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
    this.Image = props.imageConstructor
  }

  onCanvasReady(ref) {
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

  _downloadImage() {
    let unFinishImageCount = this.imageUrlMap.size
    for (const [key, url] of this.imageUrlMap.entries()) {
      const image = new this.Image(this.canvas)
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

  render() {
    const width = this.style.chessmanWidth
    const height = this.style.chessmanHeight

    if (this.context && this.imgResult.size > 0) {
      const drawBufferCache = new Array(ROW_SIZE)
      this.gameBoard.forEach((chessman, row, column) => {
        if (column === 0) {
          drawBufferCache[row] = new Array(COLUMN_SIZE)
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
              const name = decorateImage[decorate]
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

  onClick(x, y) {
    if (this.context) {
      const columnIndex = Math.floor((x - this.style.chessBoardStart) / this.style.columnGap)
      const rowIndex = Math.floor((y - this.style.chessBoardTop) / this.style.rowGap)
      console.log(`click target row = ${rowIndex}, column = ${columnIndex}`)
      this.controller.click(rowIndex, columnIndex)
    }
  }
}

export class RenderElement {
  constructor(renderFunction, ...param) {
    this.func = renderFunction
    this.param = param
  }

  equals(other) {
    if (other instanceof RenderElement) {
      return this.func === other.func && this.param.equals(other.param)
    }
    return false
  }

  drawOn(context) {
    this.func.bind(context)(...this.param)
  }
}

const ROW_SIZE = ChineseChess.ChessBoard.ROW_SIZE
const COLUMN_SIZE = ChineseChess.ChessBoard.COLUMN_SIZE

const decorateImage = (() => {
  const Decorate = ChineseChess.com.github.kchess.algorithm.chinesechess.ChineseChessUiController.Decorate
  return {
    [Decorate.Player1From]: "targetRed",
    [Decorate.Player1To]: "targetRed",
    [Decorate.Player1Select]: "targetRed",
    [Decorate.Player2From]: "targetBlack",
    [Decorate.Player2To]: "targetBlack",
    [Decorate.Player2Select]: "targetBlack",
  }
})()
