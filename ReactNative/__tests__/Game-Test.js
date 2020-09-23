import ChineseChess from "kchess-algorithm-chinesechess"

it('should getIntentAction work', function () {
  const game = new ChineseChess.ChineseChess()
  const actionList = game.getIntentAction(0, 0)
  console.log(actionList)
  console.log(actionList.toArray())
  console.log(actionList.toArray().find((e) => e.r === 1 && e.c === 0))
});
