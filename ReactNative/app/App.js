import React, {Component} from 'react';
import {Image, ImageBackground, StatusBar, StyleSheet, View} from 'react-native';
import ui from "./ui";
import ChineseChess from "kchess-algorithm-chinesechess"
import Canvas, {Image as CanvasImage} from 'react-native-canvas';

export default class App extends Component {

  constructor(props) {
    super(props);
    this.game = new ChineseChess.ChineseChess()
  }

  render() {

    return <View style={{flex: 1}}>
      <StatusBar backgroundColor={'#ffaa00'} barStyle={'light-content'}/>
      <ImageBackground style={styles.background} source={require('./img/bg.jpg')}>
        <ImageBackground style={styles.gameBoard} source={require('./img/bg.png')}>
          <Canvas ref={this.renderCanvas}/>
        </ImageBackground>
      </ImageBackground>
    </View>
  }

  static imgSrc = (() => {
    //fixme:shortcut
    const man = ChineseChess.com.github.kchess.algorithm.Chessman
    const img = new Map()
    img.set(man.红兵, require('./img/r_z.png'))
    img.set(man.红车, require('./img/r_c.png'))
    img.set(man.红士, require('./img/r_s.png'))
    img.set(man.红炮, require('./img/r_p.png'))
    img.set(man.红马, require('./img/r_m.png'))
    img.set(man.红象, require('./img/r_x.png'))
    img.set(man.红将, require('./img/r_j.png'))

    img.set(man.黑卒, require('./img/b_z.png'))
    img.set(man.黑车, require('./img/b_c.png'))
    img.set(man.黑士, require('./img/b_s.png'))
    img.set(man.黑炮, require('./img/b_p.png'))
    img.set(man.黑马, require('./img/b_m.png'))
    img.set(man.黑象, require('./img/b_x.png'))
    img.set(man.黑帅, require('./img/b_j.png'))
    return img
  })()

  onImageReady = (ctx, imgResult, ready) => {
    console.log("ready = " + ready)
    if (ready === 0) {
      let left = ui.px2dp(8)
      let top = ui.px2dp(20)
      this.game.gameBroad.forEach((newLine, chessman) => {
        if (newLine) {
          left = ui.px2dp(8)
          top += ui.px2dp(36)
        }
        if (chessman) {
          const image = imgResult[chessman]
          if (image) {
            ctx.save()
            ctx.translate(left, top)
            ctx.drawImage(image, 0, 0);
            ctx.restore()
          }
        }
        left += ui.px2dp(35)
      })
    }
  }
  renderCanvas = (canvas) => {
    if (canvas) {
      canvas.width = styles.gameBoard.width
      canvas.height = styles.gameBoard.height

      const ctx = canvas.getContext('2d');
      let readyCnt = App.imgSrc.size
      let imgResult = new Map()
      for (const [chessman, imgSrc] of App.imgSrc.entries()) {
        const image = new CanvasImage(canvas)
        image.src = Image.resolveAssetSource(imgSrc).uri
        image.addEventListener('load', () => {
          imgResult[chessman] = image
          this.onImageReady(ctx, imgResult, --readyCnt)
        });
        image.addEventListener('error', () => {
          this.onImageReady(ctx, imgResult, --readyCnt)
        });
      }
    }
  }
}

const styles = StyleSheet.create({
  background: {
    width: ui.screenWidth,
    height: ui.screenHeight,
    resizeMode: 'stretch',
    alignItems: 'center',
    justifyContent: 'center'
  },
  gameBoard: {
    width: ui.px2dp(325),
    height: ui.px2dp(403),
    resizeMode: 'cover'
  }
})


