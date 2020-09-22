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
      columnGap: props.columnGap
    }
    this.imageUrlMap = props.imageUrlMap
    this.gameBoard = props.gameBoard
    this.imgResult = new Map()
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
      let left = this.style.chessBoardStart
      let top = this.style.chessBoardTop
      const width = this.style.chessmanWidth
      const height = this.style.chessmanHeight
      // this.context.clearRect(0, 0, this.style.chessBoardWidth, this.style.chessBoardHeight)
      this.gameBoard.forEach((chessman, newLine, row, column) => {
        if (newLine) {
          left = this.style.chessBoardStart
          top += this.style.rowGap
        }
        this.context.save()
        this.context.translate(left, top)
        this.context.clearRect(0, 0, width, height)
        if (chessman) {
          const image = this.imgResult.get(chessman)
          if (image) {
            this.context.drawImage(image, 0, 0, width, height);

            if (this.selectedTarget &&
              this.selectedTarget.row === row &&
              this.selectedTarget.column === column
            ) {
              const targetDecorate = this.imgResult.get(
                chessman.owner.toBoolean() ? "targetRed" : "targetBlack")
              if (targetDecorate) {
                this.context.drawImage(targetDecorate, 0, 0, width, height);
              }
            }
          } else {
            console.error(`No Image found for ${chessman}, did 'prepareImage' has been called?`)
          }
        }
        this.context.restore()
        left += this.style.columnGap
      })
    }
  }

  onClick = ({nativeEvent}) => {
    if (this.context) {
      const columnIndex = Math.floor((nativeEvent.locationX - this.style.chessBoardStart) / this.style.columnGap)
      const rowIndex = Math.floor((nativeEvent.locationY - this.style.chessBoardTop) / this.style.rowGap)
      console.log(`click target row = ${rowIndex}, column = ${columnIndex}`)
      this.selectedTarget = {
        row: rowIndex,
        column: columnIndex
      }
      this.render()
    }
  }
}
