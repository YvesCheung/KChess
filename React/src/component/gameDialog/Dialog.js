/*
* https://ant.design/components/modal-cn/
*/
import React from "react";
import "antd/dist/antd.css";
import {Modal} from "antd";
import 'antd/dist/antd.css';
import ChineseChess from 'kchess-algorithm-chinesechess'

export const showResultDialog = (game, player, onPress) => {
  const youWin = player.toBoolean()

  if (youWin) {
    Modal.success({
      title: "Congratulation!",
      content: "You win!",
      okText: "Play Again",
      onOk() {
        console.log('OK');
        onPress()
      }
    });
  } else {
    Modal.warning({
      title: "What a pity!",
      content: "You lose!",
      okText: "Play Again",
      onOk() {
        console.log('OK');
        onPress()
      }
    });
  }

  let outputStr = 'arrayOf<Array<Chessman?>>(\n'
  game.gameBoard.forEach((chessman, newLine, row, column) => {
    if (column === 0) {
      outputStr += `\t/*${row}*/arrayOf(`
    }
    outputStr += (`/*${column}*/` + chessman)
    if (column < ChineseChess.ChessBoard.COLUMN_SIZE - 1) {
      outputStr += ", "
    } else {
      if (row === ChineseChess.ChessBoard.ROW_SIZE - 1)
        outputStr += ")\n"
      else
        outputStr += "),\n"
    }
  })
  outputStr += ')'
  console.log(outputStr)
}
