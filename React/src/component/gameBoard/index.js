import React, {Component} from "react";
import './index.css'

export default class GameBoard extends Component {

  constructor(props) {
    super(props);
    this.renderer = props.renderer
  }

  shouldComponentUpdate(nextProps, nextState, nextContext) {
    return false
  }

  render() {
    return (<div className="GameBoard">
      <canvas ref={(ref) => {
        ref.addEventListener('click', (event) => {
          this.renderer.onClick(event.offsetX, event.offsetY)
        })
        this.renderer.onCanvasReady(ref)
      }}/>
    </div>)
  }
}
