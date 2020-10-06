/**
 * @format
 */

import 'react-native';
import React from 'react';
import App from '../app/App';

// Note: test renderer must be required after react-native.
import renderer from 'react-test-renderer';

it('renders correctly', () => {
  renderer.create(<App/>);
});

it('test kotlin2js', function () {
  const algorithm = require("kchess-algorithm-chinesechess")
  const game = new algorithm.ChineseChess()
  game.gameBoard.forEach((chessman) => {
    if (chessman) {
      console.log(chessman.desc)
    } else {
      console.log('+')
    }
  })
});
