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
            //this.context.clearRect(0, 0, this.style.chessBoardWidth, this.style.chessBoardHeight)
            let left = this.style.chessBoardStart
            let top = this.style.chessBoardTop
            const width = this.style.chessmanWidth
            const height = this.style.chessmanHeight
            this.gameBoard.forEach((newLine, chessman) => {
                if (newLine) {
                    left = this.style.chessBoardStart
                    top += this.style.rowGap
                }
                if (chessman) {
                    const image = this.imgResult.get(chessman)
                    if (image) {
                        this.context.save()
                        this.context.translate(left, top)
                        this.context.drawImage(image, 0, 0, width, height);
                        this.context.restore()
                    } else {
                        console.error(`No Image found for ${chessman}, did 'prepareImage' has been called?`)
                    }
                }
                left += this.style.columnGap
            })
        }
    }
}
