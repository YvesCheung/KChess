/**
 * @format
 */

import 'react-native';
import React from 'react';
import App from '../App';

// Note: test renderer must be required after react-native.
import renderer from 'react-test-renderer';

it('renders correctly', () => {
  renderer.create(<App />);
});

it('test kotlin2js', function () {
  const algorithm = require("KChess/KChess-algorithm-chinesechess")
  const game = new algorithm.com.github.kchess.algorithm.ChineseChess()
  console.log(game.gameBroad)
});
