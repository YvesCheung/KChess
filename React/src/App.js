import React, {Component} from 'react';
import './App.css';
import ChineseChess from "kchess-algorithm-chinesechess";
import ChineseChessRenderer from "./ChineseChessRenderer";

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
      controller: this.controller
    })
  }

  render() {
    return (
      <div className="App">
        <div className="GameBoard">
          <canvas ref={(ref) => {
            ref.addEventListener('click', (event) => {
              this.renderer.onClick(event.offsetX, event.offsetY)
            })
            this.renderer.onCanvasReady(ref)
          }}/>
        </div>
      </div>
    );
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
    return img
  })()
}
