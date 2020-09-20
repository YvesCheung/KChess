import React, {Component} from 'react';
import {Image, ImageBackground, StatusBar, StyleSheet, View} from 'react-native';
import ui from "./ui";
import ChineseChess from "kchess-algorithm-chinesechess"

export default class App extends Component {

    constructor(props) {
        super(props);
        this.game = new ChineseChess.ChineseChess()
    }

    render() {
        let left = ui.px2dp(8)
        let top = ui.px2dp(20)
        const renderList = []
        this.game.gameBroad.forEach((newLine, chessman) => {
            if (newLine) {
                left = ui.px2dp(8)
                top += ui.px2dp(36)
            }
            if (chessman) {
                renderList.push({left: left, top: top, chessman: chessman})
            }
            left += ui.px2dp(35)
        })
        return <View style={{flex: 1}}>
            <StatusBar backgroundColor={'#ffaa00'} barStyle={'light-content'}/>
            <ImageBackground style={styles.background} source={require('./img/bg.jpg')}>
                <ImageBackground style={styles.gameBoard} source={require('./img/bg.png')}>
                    {
                        renderList.map((item) => {
                            return <Chessman chessman={item.chessman} x={item.left} y={item.top}/>
                        })
                    }
                </ImageBackground>
            </ImageBackground>
        </View>
    }
}

class Chessman extends Component {

    constructor(props) {
        super(props);
        this.state = {
            chessman: props.chessman,
            x: props.x,
            y: props.y
        }
    }

    static imgSrc = (() => {
        //fixme:shortcut
        const man = ChineseChess.com.github.kchess.algorithm.Chessman
        const img = new Map()
        img[man.红兵] = require('./img/r_z.png')
        img[man.红车] = require('./img/r_c.png')
        img[man.红士] = require('./img/r_s.png')
        img[man.红炮] = require('./img/r_p.png')
        img[man.红马] = require('./img/r_m.png')
        img[man.红象] = require('./img/r_x.png')
        img[man.红将] = require('./img/r_j.png')

        img[man.黑卒] = require('./img/b_z.png')
        img[man.黑车] = require('./img/b_c.png')
        img[man.黑士] = require('./img/b_s.png')
        img[man.黑炮] = require('./img/b_p.png')
        img[man.黑马] = require('./img/b_m.png')
        img[man.黑象] = require('./img/b_x.png')
        img[man.黑帅] = require('./img/b_j.png')
        return img
    })()

    render() {
        return <Image
            style={{
                position: 'absolute',
                left: this.state.x,
                top: this.state.y,
                width: ui.px2dp(30),
                height: ui.px2dp(30)
            }}
            source={Chessman.imgSrc[this.state.chessman]}/>
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


