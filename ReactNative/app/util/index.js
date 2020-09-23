// Warn if overriding existing method
if (Array.prototype.equals)
  console.warn("Overriding existing Array.prototype.equals. Possible causes: New API defines the method, there's a framework conflict or you've got double inclusions in your code.");
// attach the .equals method to Array's prototype to call it on any array
Array.prototype.equals = function (array) {
  // if the other array is a falsy value, return
  if (!array)
    return false;

  // compare lengths - can save a lot of time
  if (this.length !== array.length)
    return false;

  for (let i = 0, l = this.length; i < l; i++) {
    if (!_equals(this[i], array[i])) {
      // Warning - two different object instances will never be equal: {x:20} != {x:20}
      return false;
    }
  }
  return true;
}

_equals = (a, b) => {
  return a === b || (a.equals && a.equals(b))
}
// Hide method from for-in loops
Object.defineProperty(Array.prototype, "equals", {enumerable: false});
