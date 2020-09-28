import React, {Component} from "react";
import './index.css'

export default class GameRecord extends Component {

  constructor(props) {
    super(props);
    this.state = {
      record: []
    }
  }

  componentDidMount() {
    this.props.game.addEventListener('record', (recordList) => {
      this.setState({
        record: recordList
      }, this._scrollListToBottom)
    })
  }

  _scrollListToBottom() {
    this.list.scrollTop = this.list.offsetHeight
  }

  render() {
    return (<div className="RecordPanel">
      <text>记录(Record)</text>
      <ul ref={(ref) => this.list = ref}>
        {this.state.record.map((action, index) =>
          <li key={action.toString() + index}>{action.toString()}</li>
        )}
      </ul>
    </div>)
  }
}
