import {Image} from 'react-native-canvas';
import ChineseChess from "kchess-algorithm-chinesechess"

export default class ChineseChessRenderer {

  static ROW_SIZE = ChineseChess.ChineseChessBoard.ROW_SIZE
  static COLUMN_SIZE = ChineseChess.ChineseChessBoard.COLUMN_SIZE

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

            if (this.selectedTarget &&
              this.selectedTarget.row === row &&
              this.selectedTarget.column === column
            ) {
              const targetDecorate = this.imgResult.get(
                chessman.owner.toBoolean() ? "targetRed" : "targetBlack")
              if (targetDecorate) {
                drawBufferCache[row][column].push(
                  new RenderElement(this.context.drawImage, targetDecorate, 0, 0, width, height)
                )
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
      let needAutoMove = false
      const columnIndex = Math.floor((nativeEvent.locationX - this.style.chessBoardStart) / this.style.columnGap)
      const rowIndex = Math.floor((nativeEvent.locationY - this.style.chessBoardTop) / this.style.rowGap)
      console.log(`click target row = ${rowIndex}, column = ${columnIndex}`)
      if (this.selectedTarget) {
        const intentActions =
          this.game.getIntentAction(this.selectedTarget.row, this.selectedTarget.column)
        if (intentActions.toArray().find((action) =>
          action.row === rowIndex && action.column === columnIndex)) {
          this.game.move(
            new ChineseChess.ChineseChessAction(
              this.selectedTarget.chessman,
              this.selectedTarget.row,
              this.selectedTarget.column,
              rowIndex,
              columnIndex
            )
          )
          needAutoMove = true
        }
        this.selectedTarget = null
      } else {
        const chessman = this.gameBoard.get(rowIndex, columnIndex)
        if (chessman) {
          this.selectedTarget = {
            chessman: chessman,
            row: rowIndex,
            column: columnIndex
          }
        } else {
          this.selectedTarget = null
        }
      }

      this.render()

      if (needAutoMove) {
        setTimeout(() => {
          this.game.autoMove()
          this.render()
        }, 500)
      }
    }
  }
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
