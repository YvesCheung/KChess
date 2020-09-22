import React, {Component} from 'react';
import {PanResponder, View} from 'react-native';

export default class OnTouchEventDispatcher extends Component {

  static TouchSlop = 10

  constructor(props) {
    super(props);
    this._panResponder = PanResponder.create({
      onMoveShouldSetPanResponderCapture: () => true,
      onPanResponderGrant: this.onResponderGrant,
      onPanResponderRelease: this.onPanResponderRelease,
    });
  }

  onResponderGrant = () => {
    this.onPressTime = Date.now()
  }

  onPanResponderRelease = (event, gestureState) => {
    if (this._isClick(gestureState)) {
      console.log("click ", gestureState)
      if (this.props.listener) {
        this.props.listener.onClick(event, gestureState)
      }
    }
  }

  _isClick = (state) =>
    Math.abs(state.dx) < OnTouchEventDispatcher.TouchSlop &&
    Math.abs(state.dy) < OnTouchEventDispatcher.TouchSlop &&
    Date.now() - this.onPressTime < 500

  render() {
    return (<View style={this.props.style} {...this._panResponder.panHandlers}>
      {this.props.children}
    </View>);
  }
}
