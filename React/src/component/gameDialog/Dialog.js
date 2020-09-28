/*
* https://ant.design/components/modal-cn/
*/
import React from "react";
import "antd/dist/antd.css";
import {Modal} from "antd";
import 'antd/dist/antd.css';

export const showResultDialog = (player, onPress) => {
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
}
