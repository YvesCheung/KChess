import {Image} from 'react-native-canvas';

export default class CanvasRenderer {

  constructor(props) {
    this.style = {
      chessBoardWidth: props.chessBoardWidth,
      chessBoardHeight: props.chessBoardHeight,
      chessBoardStart: props.chessBoardStart,
      chessBoardTop: props.chessBoardTop,
      chessmanWidth: props.chessmanWidth,
      chessmanHeight: props.chessmanHeight,
      rowGap: props.rowGap,
      columnGap: props.columnGap,
      rowSize: props.rowSize,
      columnSize: props.columnSize
    }
    this.imageUrlMap = props.imageUrlMap
    this.gameBoard = props.gameBoard
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
    if (this.context && this.imgResult.size > 0) {
      const drawBufferCache = new Array(this.style.rowSize)
      this.gameBoard.forEach((chessman, newLine, row, column) => {
        if (column === 0) {
          drawBufferCache[row] = new Array(this.style.columnSize)
        }
        drawBufferCache[row][column] = []
        if (chessman) {
          const image = this.imgResult.get(chessman)
          if (image) {
            drawBufferCache[row][column].push(image)

            if (this.selectedTarget &&
              this.selectedTarget.row === row &&
              this.selectedTarget.column === column
            ) {
              const targetDecorate = this.imgResult.get(
                chessman.owner.toBoolean() ? "targetRed" : "targetBlack")
              if (targetDecorate) {
                drawBufferCache[row][column].push(targetDecorate)
              }
            }
          } else {
            console.error(`No Image found for ${chessman}, did 'prepareImage' has been called?`)
          }
        }
      })

      let left = this.style.chessBoardStart
      let top = this.style.chessBoardTop
      const width = this.style.chessmanWidth
      const height = this.style.chessmanHeight
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
              this.context.drawImage(element, 0, 0, width, height)
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
      if (this.gameBoard.get(rowIndex, columnIndex)) {
        this.selectedTarget = {
          row: rowIndex,
          column: columnIndex
        }
      }
      this.render()
    }
  }
}
