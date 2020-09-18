(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'kchess-algorithm'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'kchess-algorithm'.");
    }root['kchess-algorithm'] = factory(typeof this['kchess-algorithm'] === 'undefined' ? {} : this['kchess-algorithm'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init_pdl1vj$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Enum = Kotlin.kotlin.Enum;
  var throwISE = Kotlin.throwISE;
  OwnerShip.prototype = Object.create(Enum.prototype);
  OwnerShip.prototype.constructor = OwnerShip;
  function GameAction() {
  }
  GameAction.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'GameAction',
    interfaces: []
  };
  function GameActionSearch() {
  }
  GameActionSearch.prototype.alphaBetaSearch_ss2bde$ = function (depth, context, player) {
    if (player === void 0)
      player = OwnerShip$Player2_getInstance();
    return this.alphaBetaSearch_kas4fq$_0(depth, -2147483647, 2147483647, context, player);
  };
  GameActionSearch.prototype.alphaBetaSearch_kas4fq$_0 = function (depth, alpha, beta, context, player) {
    var tmp$;
    if (depth < 0) {
      throw IllegalArgumentException_init('depth must be >= 0, but actual value is ' + depth + '!');
    }if (depth === 0) {
      return new GameSearchResult(null, this.evaluate_nw8la0$(context, player));
    }var maxAlpha = alpha;
    var alphaAction = null;
    tmp$ = this.nextMove_nw8la0$(context, player).iterator();
    while (tmp$.hasNext()) {
      var action = tmp$.next();
      action.run_11rb$(context);
      var result = this.alphaBetaSearch_kas4fq$_0(depth - 1 | 0, -beta | 0, -maxAlpha | 0, context, player.unaryMinus());
      var value = -result.evaluateValue | 0;
      action.undo_11rb$(context);
      if (value >= beta) {
        return new GameSearchResult(action, value);
      }if (value > maxAlpha) {
        maxAlpha = value;
        alphaAction = action;
      }}
    return new GameSearchResult(alphaAction, maxAlpha);
  };
  GameActionSearch.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'GameActionSearch',
    interfaces: []
  };
  function GameSearchResult(action, evaluateValue) {
    this.action = action;
    this.evaluateValue = evaluateValue;
  }
  GameSearchResult.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'GameSearchResult',
    interfaces: []
  };
  GameSearchResult.prototype.component1 = function () {
    return this.action;
  };
  GameSearchResult.prototype.component2 = function () {
    return this.evaluateValue;
  };
  GameSearchResult.prototype.copy_czjjuo$ = function (action, evaluateValue) {
    return new GameSearchResult(action === void 0 ? this.action : action, evaluateValue === void 0 ? this.evaluateValue : evaluateValue);
  };
  GameSearchResult.prototype.toString = function () {
    return 'GameSearchResult(action=' + Kotlin.toString(this.action) + (', evaluateValue=' + Kotlin.toString(this.evaluateValue)) + ')';
  };
  GameSearchResult.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.action) | 0;
    result = result * 31 + Kotlin.hashCode(this.evaluateValue) | 0;
    return result;
  };
  GameSearchResult.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.action, other.action) && Kotlin.equals(this.evaluateValue, other.evaluateValue)))));
  };
  function OwnerShip(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function OwnerShip_initFields() {
    OwnerShip_initFields = function () {
    };
    OwnerShip$Player1_instance = new OwnerShip('Player1', 0);
    OwnerShip$Player2_instance = new OwnerShip('Player2', 1);
  }
  var OwnerShip$Player1_instance;
  function OwnerShip$Player1_getInstance() {
    OwnerShip_initFields();
    return OwnerShip$Player1_instance;
  }
  var OwnerShip$Player2_instance;
  function OwnerShip$Player2_getInstance() {
    OwnerShip_initFields();
    return OwnerShip$Player2_instance;
  }
  OwnerShip.prototype.not = function () {
    return !this.toBoolean();
  };
  OwnerShip.prototype.unaryMinus = function () {
    return this === OwnerShip$Player1_getInstance() ? OwnerShip$Player2_getInstance() : OwnerShip$Player1_getInstance();
  };
  OwnerShip.prototype.toBoolean = function () {
    return this === OwnerShip$Player1_getInstance();
  };
  OwnerShip.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'OwnerShip',
    interfaces: [Enum]
  };
  function OwnerShip$values() {
    return [OwnerShip$Player1_getInstance(), OwnerShip$Player2_getInstance()];
  }
  OwnerShip.values = OwnerShip$values;
  function OwnerShip$valueOf(name) {
    switch (name) {
      case 'Player1':
        return OwnerShip$Player1_getInstance();
      case 'Player2':
        return OwnerShip$Player2_getInstance();
      default:throwISE('No enum constant com.github.kchess.algorithm.OwnerShip.' + name);
    }
  }
  OwnerShip.valueOf_61zpoe$ = OwnerShip$valueOf;
  var package$com = _.com || (_.com = {});
  var package$github = package$com.github || (package$com.github = {});
  var package$kchess = package$github.kchess || (package$github.kchess = {});
  var package$algorithm = package$kchess.algorithm || (package$kchess.algorithm = {});
  package$algorithm.GameAction = GameAction;
  package$algorithm.GameActionSearch = GameActionSearch;
  package$algorithm.GameSearchResult = GameSearchResult;
  Object.defineProperty(OwnerShip, 'Player1', {
    get: OwnerShip$Player1_getInstance
  });
  Object.defineProperty(OwnerShip, 'Player2', {
    get: OwnerShip$Player2_getInstance
  });
  package$algorithm.OwnerShip = OwnerShip;
  Kotlin.defineModule('kchess-algorithm', _);
  return _;
}));

//# sourceMappingURL=kchess-algorithm.js.map
