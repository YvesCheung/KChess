import {RenderElement} from '../app/ChineseChessRenderer'

it('should renderElement equals', function () {
  require('../app/util')

  let testVar = 0
  const func1 = (a, b) => {
    testVar = a
  }
  const func2 = (a, b) => {
    testVar = b
  }

  const a = new RenderElement(func1, 2, 3)
  const b = new RenderElement(func1, 2, 3)
  const c = new RenderElement(func1, 3, 2)
  const d = new RenderElement(func2, 2, 3)

  expect(a.equals(b)).toBe(true)
  expect(a.equals(c)).toBe(false)
  expect(a.equals(d)).toBe(false)

  expect(testVar).toBe(0)
  a.drawOn(this)
  expect(testVar).toBe(2)
  d.drawOn(this)
  expect(testVar).toBe(3)
});

it('should RenderElement List equals', function () {
  require('../app/util')

  let testVar = 0
  const func1 = (a, b) => {
    testVar = a
  }
  const func2 = (a, b) => {
    testVar = b
  }

  const a = new RenderElement(func1, 2, 3)
  const b = new RenderElement(func1, 2, 3)
  const c = new RenderElement(func1, 3, 2)
  const d = new RenderElement(func2, 2, 3)

  const list1 = [a, c]
  const list2 = [a, c]
  const list3 = [b, c]
  const list4 = [a, c, d]
  const list5 = [a, d]

  expect(list1.equals(list1)).toBe(true)
  expect(list1.equals(list2)).toBe(true)
  expect(list1.equals(list3)).toBe(true)

  expect(list1.equals(list4)).toBe(false)
  expect(list1.equals(list5)).toBe(false)
});
