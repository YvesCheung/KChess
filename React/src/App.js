import React, {Component} from 'react';
import './App.css';
import ChineseChess from "kchess-algorithm-chinesechess";
import {ChineseChessRenderer} from "kchess-react-shared";
import GameBoard from "./component/gameBoard";
import GameRecord from "./component/gameRecord";
import {showResultDialog} from "./component/gameDialog/Dialog"

export default class App extends Component {

  constructor(props) {
    super(props);
    this.game = new ChineseChess.ChineseChess()
    this.controller = new ChineseChess.Controller(this.game)
    this.renderer = new ChineseChessRenderer({
      chessBoardWidth: 650,
      chessBoardHeight: 806,
      chessBoardStart: 16,
      chessBoardTop: 40,
      chessmanWidth: 60,
      chessmanHeight: 60,
      rowGap: 72,
      columnGap: 70,
      imageUrlMap: App.imgSrc,
      game: this.game,
      controller: this.controller,
      imageConstructor: Image
    })
  }

  componentDidMount() {
    this.game.addEventListener('over', ([winner]) => {
      console.log("GameOver, winner is " + winner)
      showResultDialog(winner, () => this._reset())
    })
  }

  render() {
    const isPhone = window.matchMedia("screen and (max-width: 768px)")
    return isPhone.matches
      ? (
        <div className="App">
          <GameBoard renderer={this.renderer}/>
        </div>
      )
      : (
        <div className="App">
          <GameBoard renderer={this.renderer}/>
          <div className="CtrlPanel">
            <GameRecord game={this.game}/>
            <button onClick={() => this._assistance()}>帮你走 (ASSISTANCE)</button>
            <button onClick={() => this._regret()}>悔棋 (REGRET)</button>
            <button onClick={() => this._reset()}>重置 (RESET)</button>
          </div>
        </div>
      );
  }

  _assistance() {
    setTimeout(() => {
      this.game.autoMove()
      this.renderer.render()
      setTimeout(() => {
        this.game.autoMove()
        this.renderer.render()
      }, 500)
    }, 500)
  }

  _regret() {
    this.game.regret()
    this.renderer.render()
  }

  _reset() {
    this.game.reset()
    this.renderer.render()
  }

  static imgSrc = (() => {
    //fixme:shortcut
    const man = ChineseChess.com.github.kchess.algorithm.chinesechess.Chessman
    const img = new Map()
    img.set(man.红兵, require('kchess-react-shared/img/r_z.png'))
    img.set(man.红车, require('kchess-react-shared/img/r_c.png'))
    img.set(man.红士, require('kchess-react-shared/img/r_s.png'))
    img.set(man.红炮, require('kchess-react-shared/img/r_p.png'))
    img.set(man.红马, require('kchess-react-shared/img/r_m.png'))
    img.set(man.红象, require('kchess-react-shared/img/r_x.png'))
    img.set(man.红将, require('kchess-react-shared/img/r_j.png'))

    img.set(man.黑卒, require('kchess-react-shared/img/b_z.png'))
    img.set(man.黑车, require('kchess-react-shared/img/b_c.png'))
    img.set(man.黑士, require('kchess-react-shared/img/b_s.png'))
    img.set(man.黑炮, require('kchess-react-shared/img/b_p.png'))
    img.set(man.黑马, require('kchess-react-shared/img/b_m.png'))
    img.set(man.黑象, require('kchess-react-shared/img/b_x.png'))
    img.set(man.黑帅, require('kchess-react-shared/img/b_j.png'))

    img.set("targetRed", require('kchess-react-shared/img/r_box.png'))
    img.set("targetBlack", require('kchess-react-shared/img/b_box.png'))
    return img
  })()
}
