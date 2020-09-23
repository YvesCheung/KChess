import React, {Component} from 'react';
import {Image, ImageBackground, StatusBar, StyleSheet, View} from 'react-native';
import ui from "./ui";
import ChineseChess from "kchess-algorithm-chinesechess"
import Canvas from 'react-native-canvas';
import ChineseChessRenderer from './ChineseChessRenderer'
import OnTouchEventDispatcher from "./OnTouchEventDispatcher";

export default class App extends Component {

  constructor(props) {
    super(props);
    this.game = new ChineseChess.ChineseChess()
    this.controller = new ChineseChess.Controller(this.game)
    this.renderer = new ChineseChessRenderer({
      chessBoardWidth: styles.gameBoard.width,
      chessBoardHeight: styles.gameBoard.height,
      chessBoardStart: ui.px2dp(8),
      chessBoardTop: ui.px2dp(20),
      chessmanWidth: ui.px2dp(30),
      chessmanHeight: ui.px2dp(30),
      rowGap: ui.px2dp(36),
      columnGap: ui.px2dp(35),
      imageUrlMap: App.imgSrc,
      game: this.game,
      controller: this.controller
    })
  }

  shouldComponentUpdate(nextProps, nextState, nextContext) {
    return false
  }

  render() {
    return <View style={{flex: 1}}>
      <StatusBar backgroundColor={'#ffaa00'} barStyle={'light-content'}/>
      <ImageBackground style={styles.background} source={require('./img/bg.jpg')}>
        <ImageBackground style={styles.gameBoard} source={require('./img/bg.png')}>
          <OnTouchEventDispatcher listener={this.renderer}>
            <Canvas ref={this.renderer.onCanvasReady}/>
          </OnTouchEventDispatcher>
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

    img.set("targetRed", require('./img/r_box.png'))
    img.set("targetBlack", require('./img/b_box.png'))

    for ([key, value] of img.entries()) {
      img.set(key, Image.resolveAssetSource(value).uri)
    }
    return img
  })()
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


