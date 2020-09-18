(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kchess-algorithm'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kchess-algorithm'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'kchess-algorithm-chinesechess'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'kchess-algorithm-chinesechess'.");
    }if (typeof this['kchess-algorithm'] === 'undefined') {
      throw new Error("Error loading module 'kchess-algorithm-chinesechess'. Its dependency 'kchess-algorithm' was not found. Please, check whether 'kchess-algorithm' is loaded prior to 'kchess-algorithm-chinesechess'.");
    }root['kchess-algorithm-chinesechess'] = factory(typeof this['kchess-algorithm-chinesechess'] === 'undefined' ? {} : this['kchess-algorithm-chinesechess'], kotlin, this['kchess-algorithm']);
  }
}(this, function (_, Kotlin, $module$kchess_algorithm) {
  'use strict';
  var OwnerShip = $module$kchess_algorithm.com.github.kchess.algorithm.OwnerShip;
  var Enum = Kotlin.kotlin.Enum;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var throwISE = Kotlin.throwISE;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var COROUTINE_SUSPENDED = Kotlin.kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED;
  var CoroutineImpl = Kotlin.kotlin.coroutines.CoroutineImpl;
  var Unit = Kotlin.kotlin.Unit;
  var sequence = Kotlin.kotlin.sequences.sequence_o0x0bg$;
  var filter = Kotlin.kotlin.sequences.filter_euau3h$;
  var equals = Kotlin.equals;
  var GameAction = $module$kchess_algorithm.com.github.kchess.algorithm.GameAction;
  var throwUPAE = Kotlin.throwUPAE;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init_pdl1vj$;
  var iterator = Kotlin.kotlin.sequences.iterator_o0x0bg$;
  var Iterable = Kotlin.kotlin.collections.Iterable;
  var map = Kotlin.kotlin.sequences.map_z5avom$;
  var GameActionSearch = $module$kchess_algorithm.com.github.kchess.algorithm.GameActionSearch;
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var ensureNotNull = Kotlin.ensureNotNull;
  var LinkedHashMap_init = Kotlin.kotlin.collections.LinkedHashMap_init_q3lmfv$;
  Chessman.prototype = Object.create(Enum.prototype);
  Chessman.prototype.constructor = Chessman;
  ChessmanEvaluator.prototype = Object.create(Enum.prototype);
  ChessmanEvaluator.prototype.constructor = ChessmanEvaluator;
  ChessmanEvaluator$Che.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Che.prototype.constructor = ChessmanEvaluator$Che;
  ChessmanEvaluator$Ma.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Ma.prototype.constructor = ChessmanEvaluator$Ma;
  ChessmanEvaluator$Xiang.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Xiang.prototype.constructor = ChessmanEvaluator$Xiang;
  ChessmanEvaluator$Shi.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Shi.prototype.constructor = ChessmanEvaluator$Shi;
  ChessmanEvaluator$jiang.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$jiang.prototype.constructor = ChessmanEvaluator$jiang;
  ChessmanEvaluator$Pao.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Pao.prototype.constructor = ChessmanEvaluator$Pao;
  ChessmanEvaluator$Zu.prototype = Object.create(ChessmanEvaluator.prototype);
  ChessmanEvaluator$Zu.prototype.constructor = ChessmanEvaluator$Zu;
  ChessmanRule.prototype = Object.create(Enum.prototype);
  ChessmanRule.prototype.constructor = ChessmanRule;
  ChessmanRule$Che.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Che.prototype.constructor = ChessmanRule$Che;
  ChessmanRule$Ma.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Ma.prototype.constructor = ChessmanRule$Ma;
  ChessmanRule$Shi.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Shi.prototype.constructor = ChessmanRule$Shi;
  ChessmanRule$Xiang.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Xiang.prototype.constructor = ChessmanRule$Xiang;
  ChessmanRule$Jiang.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Jiang.prototype.constructor = ChessmanRule$Jiang;
  ChessmanRule$Bin.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Bin.prototype.constructor = ChessmanRule$Bin;
  ChessmanRule$Pao.prototype = Object.create(ChessmanRule.prototype);
  ChessmanRule$Pao.prototype.constructor = ChessmanRule$Pao;
  ChineseChessSearch.prototype = Object.create(GameActionSearch.prototype);
  ChineseChessSearch.prototype.constructor = ChineseChessSearch;
  function Chessman(name, ordinal, owner, desc) {
    Enum.call(this);
    this.owner = owner;
    this.desc = desc;
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function Chessman_initFields() {
    Chessman_initFields = function () {
    };
    Chessman$红车_instance = new Chessman('\u7EA2\u8F66', 0, OwnerShip.Player1, '\u7EA2\u8F66');
    Chessman$红马_instance = new Chessman('\u7EA2\u9A6C', 1, OwnerShip.Player1, '\u7EA2\u9A6C');
    Chessman$红象_instance = new Chessman('\u7EA2\u8C61', 2, OwnerShip.Player1, '\u7EA2\u8C61');
    Chessman$红士_instance = new Chessman('\u7EA2\u58EB', 3, OwnerShip.Player1, '\u7EA2\u58EB');
    Chessman$红将_instance = new Chessman('\u7EA2\u5C06', 4, OwnerShip.Player1, '\u7EA2\u5C06');
    Chessman$红炮_instance = new Chessman('\u7EA2\u70AE', 5, OwnerShip.Player1, '\u7EA2\u70AE');
    Chessman$红兵_instance = new Chessman('\u7EA2\u5175', 6, OwnerShip.Player1, '\u7EA2\u5175');
    Chessman$黑车_instance = new Chessman('\u9ED1\u8F66', 7, OwnerShip.Player2, '\u9ED1\u8F66');
    Chessman$黑马_instance = new Chessman('\u9ED1\u9A6C', 8, OwnerShip.Player2, '\u9ED1\u9A6C');
    Chessman$黑象_instance = new Chessman('\u9ED1\u8C61', 9, OwnerShip.Player2, '\u9ED1\u8C61');
    Chessman$黑士_instance = new Chessman('\u9ED1\u58EB', 10, OwnerShip.Player2, '\u9ED1\u58EB');
    Chessman$黑帅_instance = new Chessman('\u9ED1\u5E05', 11, OwnerShip.Player2, '\u9ED1\u5E05');
    Chessman$黑炮_instance = new Chessman('\u9ED1\u70AE', 12, OwnerShip.Player2, '\u9ED1\u70AE');
    Chessman$黑卒_instance = new Chessman('\u9ED1\u5352', 13, OwnerShip.Player2, '\u9ED1\u5352');
  }
  var Chessman$红车_instance;
  function Chessman$红车_getInstance() {
    Chessman_initFields();
    return Chessman$红车_instance;
  }
  var Chessman$红马_instance;
  function Chessman$红马_getInstance() {
    Chessman_initFields();
    return Chessman$红马_instance;
  }
  var Chessman$红象_instance;
  function Chessman$红象_getInstance() {
    Chessman_initFields();
    return Chessman$红象_instance;
  }
  var Chessman$红士_instance;
  function Chessman$红士_getInstance() {
    Chessman_initFields();
    return Chessman$红士_instance;
  }
  var Chessman$红将_instance;
  function Chessman$红将_getInstance() {
    Chessman_initFields();
    return Chessman$红将_instance;
  }
  var Chessman$红炮_instance;
  function Chessman$红炮_getInstance() {
    Chessman_initFields();
    return Chessman$红炮_instance;
  }
  var Chessman$红兵_instance;
  function Chessman$红兵_getInstance() {
    Chessman_initFields();
    return Chessman$红兵_instance;
  }
  var Chessman$黑车_instance;
  function Chessman$黑车_getInstance() {
    Chessman_initFields();
    return Chessman$黑车_instance;
  }
  var Chessman$黑马_instance;
  function Chessman$黑马_getInstance() {
    Chessman_initFields();
    return Chessman$黑马_instance;
  }
  var Chessman$黑象_instance;
  function Chessman$黑象_getInstance() {
    Chessman_initFields();
    return Chessman$黑象_instance;
  }
  var Chessman$黑士_instance;
  function Chessman$黑士_getInstance() {
    Chessman_initFields();
    return Chessman$黑士_instance;
  }
  var Chessman$黑帅_instance;
  function Chessman$黑帅_getInstance() {
    Chessman_initFields();
    return Chessman$黑帅_instance;
  }
  var Chessman$黑炮_instance;
  function Chessman$黑炮_getInstance() {
    Chessman_initFields();
    return Chessman$黑炮_instance;
  }
  var Chessman$黑卒_instance;
  function Chessman$黑卒_getInstance() {
    Chessman_initFields();
    return Chessman$黑卒_instance;
  }
  Chessman.prototype.toString = function () {
    return this.desc;
  };
  Chessman.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Chessman',
    interfaces: [Enum]
  };
  function Chessman$values() {
    return [Chessman$红车_getInstance(), Chessman$红马_getInstance(), Chessman$红象_getInstance(), Chessman$红士_getInstance(), Chessman$红将_getInstance(), Chessman$红炮_getInstance(), Chessman$红兵_getInstance(), Chessman$黑车_getInstance(), Chessman$黑马_getInstance(), Chessman$黑象_getInstance(), Chessman$黑士_getInstance(), Chessman$黑帅_getInstance(), Chessman$黑炮_getInstance(), Chessman$黑卒_getInstance()];
  }
  Chessman.values = Chessman$values;
  function Chessman$valueOf(name) {
    switch (name) {
      case '\u7EA2\u8F66':
        return Chessman$红车_getInstance();
      case '\u7EA2\u9A6C':
        return Chessman$红马_getInstance();
      case '\u7EA2\u8C61':
        return Chessman$红象_getInstance();
      case '\u7EA2\u58EB':
        return Chessman$红士_getInstance();
      case '\u7EA2\u5C06':
        return Chessman$红将_getInstance();
      case '\u7EA2\u70AE':
        return Chessman$红炮_getInstance();
      case '\u7EA2\u5175':
        return Chessman$红兵_getInstance();
      case '\u9ED1\u8F66':
        return Chessman$黑车_getInstance();
      case '\u9ED1\u9A6C':
        return Chessman$黑马_getInstance();
      case '\u9ED1\u8C61':
        return Chessman$黑象_getInstance();
      case '\u9ED1\u58EB':
        return Chessman$黑士_getInstance();
      case '\u9ED1\u5E05':
        return Chessman$黑帅_getInstance();
      case '\u9ED1\u70AE':
        return Chessman$黑炮_getInstance();
      case '\u9ED1\u5352':
        return Chessman$黑卒_getInstance();
      default:throwISE('No enum constant com.github.kchess.algorithm.Chessman.' + name);
    }
  }
  Chessman.valueOf_61zpoe$ = Chessman$valueOf;
  function ChessmanEvaluator(name, ordinal, chessman) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
    this.productName_e328ib$_0 = chessman;
  }
  function ChessmanEvaluator_initFields() {
    ChessmanEvaluator_initFields = function () {
    };
    new ChessmanEvaluator$Che();
    new ChessmanEvaluator$Ma();
    new ChessmanEvaluator$Xiang();
    new ChessmanEvaluator$Shi();
    new ChessmanEvaluator$jiang();
    new ChessmanEvaluator$Pao();
    new ChessmanEvaluator$Zu();
    ChessmanEvaluator$Companion_getInstance();
  }
  function ChessmanEvaluator$Che() {
    ChessmanEvaluator$Che_instance = this;
    ChessmanEvaluator.call(this, 'Che', 0, [Chessman$红车_getInstance(), Chessman$黑车_getInstance()]);
    this.valueMap_3ivc5u$_0 = [new Int32Array([206, 208, 207, 213, 214, 213, 207, 208, 206]), new Int32Array([206, 212, 209, 216, 233, 216, 209, 212, 206]), new Int32Array([206, 208, 207, 214, 216, 214, 207, 208, 206]), new Int32Array([206, 213, 213, 216, 216, 216, 213, 213, 206]), new Int32Array([208, 211, 211, 214, 215, 214, 211, 211, 208]), new Int32Array([208, 212, 212, 214, 215, 214, 212, 212, 208]), new Int32Array([204, 209, 204, 212, 214, 212, 204, 209, 204]), new Int32Array([198, 208, 204, 212, 212, 212, 204, 208, 198]), new Int32Array([200, 208, 206, 212, 200, 212, 206, 208, 200]), new Int32Array([194, 206, 204, 212, 200, 212, 204, 206, 194])];
  }
  Object.defineProperty(ChessmanEvaluator$Che.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_3ivc5u$_0;
    }
  });
  ChessmanEvaluator$Che.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Che',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Che_instance = null;
  function ChessmanEvaluator$Che_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Che_instance;
  }
  function ChessmanEvaluator$Ma() {
    ChessmanEvaluator$Ma_instance = this;
    ChessmanEvaluator.call(this, 'Ma', 1, [Chessman$红马_getInstance(), Chessman$黑马_getInstance()]);
    this.valueMap_tdq31k$_0 = [new Int32Array([90, 90, 90, 96, 90, 96, 90, 90, 90]), new Int32Array([90, 96, 103, 97, 94, 97, 103, 96, 90]), new Int32Array([92, 98, 99, 103, 99, 103, 99, 98, 92]), new Int32Array([93, 108, 100, 107, 100, 107, 100, 108, 93]), new Int32Array([90, 100, 99, 103, 104, 103, 99, 100, 90]), new Int32Array([90, 98, 101, 102, 103, 102, 101, 98, 90]), new Int32Array([92, 94, 98, 95, 98, 95, 98, 94, 92]), new Int32Array([93, 92, 94, 95, 92, 95, 94, 92, 93]), new Int32Array([85, 90, 92, 93, 78, 93, 92, 90, 85]), new Int32Array([88, 85, 90, 88, 90, 88, 90, 85, 88])];
  }
  Object.defineProperty(ChessmanEvaluator$Ma.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_tdq31k$_0;
    }
  });
  ChessmanEvaluator$Ma.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Ma',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Ma_instance = null;
  function ChessmanEvaluator$Ma_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Ma_instance;
  }
  function ChessmanEvaluator$Xiang() {
    ChessmanEvaluator$Xiang_instance = this;
    ChessmanEvaluator.call(this, 'Xiang', 2, [Chessman$红象_getInstance(), Chessman$黑象_getInstance()]);
    this.valueMap_gdmf55$_0 = [new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 20, 0, 0, 0, 20, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([18, 0, 0, 0, 23, 0, 0, 0, 18]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 20, 0, 0, 0, 20, 0, 0])];
  }
  Object.defineProperty(ChessmanEvaluator$Xiang.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_gdmf55$_0;
    }
  });
  ChessmanEvaluator$Xiang.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Xiang',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Xiang_instance = null;
  function ChessmanEvaluator$Xiang_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Xiang_instance;
  }
  function ChessmanEvaluator$Shi() {
    ChessmanEvaluator$Shi_instance = this;
    ChessmanEvaluator.call(this, 'Shi', 3, [Chessman$红士_getInstance(), Chessman$黑士_getInstance()]);
    this.valueMap_d22w8y$_0 = [new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 20, 0, 20, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 23, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 20, 0, 20, 0, 0, 0])];
  }
  Object.defineProperty(ChessmanEvaluator$Shi.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_d22w8y$_0;
    }
  });
  ChessmanEvaluator$Shi.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Shi',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Shi_instance = null;
  function ChessmanEvaluator$Shi_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Shi_instance;
  }
  function ChessmanEvaluator$jiang() {
    ChessmanEvaluator$jiang_instance = this;
    ChessmanEvaluator.call(this, 'jiang', 4, [Chessman$红将_getInstance(), Chessman$黑帅_getInstance()]);
    this.valueMap_67qgkp$_0 = [new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0]), new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0]), new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0]), new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0]), new Int32Array([0, 0, 0, 99999, 99999, 99999, 0, 0, 0])];
  }
  Object.defineProperty(ChessmanEvaluator$jiang.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_67qgkp$_0;
    }
  });
  ChessmanEvaluator$jiang.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'jiang',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$jiang_instance = null;
  function ChessmanEvaluator$jiang_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$jiang_instance;
  }
  function ChessmanEvaluator$Pao() {
    ChessmanEvaluator$Pao_instance = this;
    ChessmanEvaluator.call(this, 'Pao', 5, [Chessman$红炮_getInstance(), Chessman$黑炮_getInstance()]);
    this.valueMap_nkrbh0$_0 = [new Int32Array([100, 100, 96, 91, 90, 91, 96, 100, 100]), new Int32Array([98, 98, 96, 92, 89, 92, 96, 98, 98]), new Int32Array([97, 97, 96, 91, 92, 91, 96, 97, 97]), new Int32Array([96, 99, 99, 98, 100, 98, 99, 99, 96]), new Int32Array([96, 96, 96, 96, 100, 96, 96, 96, 96]), new Int32Array([95, 96, 99, 96, 100, 96, 99, 96, 95]), new Int32Array([96, 96, 96, 96, 96, 96, 96, 96, 96]), new Int32Array([97, 96, 100, 99, 101, 99, 100, 96, 97]), new Int32Array([96, 97, 98, 98, 98, 98, 98, 97, 96]), new Int32Array([96, 96, 97, 99, 99, 99, 97, 96, 96])];
  }
  Object.defineProperty(ChessmanEvaluator$Pao.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_nkrbh0$_0;
    }
  });
  ChessmanEvaluator$Pao.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Pao',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Pao_instance = null;
  function ChessmanEvaluator$Pao_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Pao_instance;
  }
  function ChessmanEvaluator$Zu() {
    ChessmanEvaluator$Zu_instance = this;
    ChessmanEvaluator.call(this, 'Zu', 6, [Chessman$红兵_getInstance(), Chessman$黑卒_getInstance()]);
    this.valueMap_v0jf7z$_0 = [new Int32Array([9, 9, 9, 11, 13, 11, 9, 9, 9]), new Int32Array([19, 24, 34, 42, 44, 42, 34, 24, 19]), new Int32Array([19, 24, 32, 37, 37, 37, 32, 24, 19]), new Int32Array([19, 23, 27, 29, 30, 29, 27, 23, 19]), new Int32Array([14, 18, 20, 27, 29, 27, 20, 18, 14]), new Int32Array([7, 0, 13, 0, 16, 0, 13, 0, 7]), new Int32Array([7, 0, 7, 0, 15, 0, 7, 0, 7]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0]), new Int32Array([0, 0, 0, 0, 0, 0, 0, 0, 0])];
  }
  Object.defineProperty(ChessmanEvaluator$Zu.prototype, 'valueMap', {
    get: function () {
      return this.valueMap_v0jf7z$_0;
    }
  });
  ChessmanEvaluator$Zu.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Zu',
    interfaces: [ChessmanEvaluator]
  };
  var ChessmanEvaluator$Zu_instance = null;
  function ChessmanEvaluator$Zu_getInstance() {
    ChessmanEvaluator_initFields();
    return ChessmanEvaluator$Zu_instance;
  }
  Object.defineProperty(ChessmanEvaluator.prototype, 'productName', {
    get: function () {
      return this.productName_e328ib$_0;
    }
  });
  function ChessmanEvaluator$Companion() {
    ChessmanEvaluator$Companion_instance = this;
    this.factory_0 = toFactory(ChessmanEvaluator$values());
  }
  ChessmanEvaluator$Companion.prototype.evaluate_jght4t$ = function (chessman, row, column, player) {
    var tmp$, tmp$_0;
    var evaluator = this.factory_0.create_11rb$(chessman);
    if (chessman.owner.not()) {
      tmp$ = evaluator.valueMap[10 - row - 1 | 0][9 - column - 1 | 0];
    } else {
      tmp$ = evaluator.valueMap[row][column];
    }
    var evaluate = tmp$;
    if (chessman.owner !== player) {
      tmp$_0 = -evaluate | 0;
    } else {
      tmp$_0 = evaluate;
    }
    return tmp$_0;
  };
  ChessmanEvaluator$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var ChessmanEvaluator$Companion_instance = null;
  function ChessmanEvaluator$Companion_getInstance() {
    ChessmanEvaluator_initFields();
    if (ChessmanEvaluator$Companion_instance === null) {
      new ChessmanEvaluator$Companion();
    }return ChessmanEvaluator$Companion_instance;
  }
  ChessmanEvaluator.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChessmanEvaluator',
    interfaces: [Producible, Enum]
  };
  function ChessmanEvaluator$values() {
    return [ChessmanEvaluator$Che_getInstance(), ChessmanEvaluator$Ma_getInstance(), ChessmanEvaluator$Xiang_getInstance(), ChessmanEvaluator$Shi_getInstance(), ChessmanEvaluator$jiang_getInstance(), ChessmanEvaluator$Pao_getInstance(), ChessmanEvaluator$Zu_getInstance()];
  }
  ChessmanEvaluator.values = ChessmanEvaluator$values;
  function ChessmanEvaluator$valueOf(name) {
    switch (name) {
      case 'Che':
        return ChessmanEvaluator$Che_getInstance();
      case 'Ma':
        return ChessmanEvaluator$Ma_getInstance();
      case 'Xiang':
        return ChessmanEvaluator$Xiang_getInstance();
      case 'Shi':
        return ChessmanEvaluator$Shi_getInstance();
      case 'jiang':
        return ChessmanEvaluator$jiang_getInstance();
      case 'Pao':
        return ChessmanEvaluator$Pao_getInstance();
      case 'Zu':
        return ChessmanEvaluator$Zu_getInstance();
      default:throwISE('No enum constant com.github.kchess.algorithm.ChessmanEvaluator.' + name);
    }
  }
  ChessmanEvaluator.valueOf_61zpoe$ = ChessmanEvaluator$valueOf;
  function ChessmanRule(name, ordinal, chessman) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
    this.productName_uxulvm$_0 = chessman;
  }
  function ChessmanRule_initFields() {
    ChessmanRule_initFields = function () {
    };
    new ChessmanRule$Che();
    new ChessmanRule$Ma();
    new ChessmanRule$Shi();
    new ChessmanRule$Xiang();
    new ChessmanRule$Jiang();
    new ChessmanRule$Bin();
    new ChessmanRule$Pao();
    ChessmanRule$Companion_getInstance();
  }
  function ChessmanRule$Che() {
    ChessmanRule$Che_instance = this;
    ChessmanRule.call(this, 'Che', 0, [Chessman$红车_getInstance(), Chessman$黑车_getInstance()]);
  }
  function Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition(closure$game_0, closure$owner_0, $receiver_0, r_0, c_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$game = closure$game_0;
    this.local$closure$owner = closure$owner_0;
    this.local$target = void 0;
    this.local$$receiver = $receiver_0;
    this.local$r = r_0;
    this.local$c = c_0;
  }
  Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition.prototype.constructor = Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition;
  Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$target = this.local$closure$game.gameBroad.get_vux9f0$(this.local$r, this.local$c);
            if (this.local$target == null || this.local$target.owner !== this.local$closure$owner) {
              this.state_0 = 2;
              this.result_0 = this.local$$receiver.yield_11rb$(new Position(this.local$r, this.local$c), this);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              continue;
            } else {
              this.state_0 = 3;
              continue;
            }

          case 1:
            throw this.exception_0;
          case 2:
            this.state_0 = 3;
            continue;
          case 3:
            return this.local$target != null;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChessmanRule$Che$nextMove$lambda$yieldPosition(closure$game_0, closure$owner_0) {
    return function ($receiver_0, r_0, c_0, continuation_0, suspended) {
      var instance = new Coroutine$ChessmanRule$Che$nextMove$lambda$yieldPosition(closure$game_0, closure$owner_0, $receiver_0, r_0, c_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$ChessmanRule$Che$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$game = closure$game_0;
    this.local$closure$owner = closure$owner_0;
    this.local$closure$current = closure$current_0;
    this.local$yieldPosition = void 0;
    this.local$r = void 0;
    this.local$r_0 = void 0;
    this.local$c = void 0;
    this.local$c_0 = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$ChessmanRule$Che$nextMove$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChessmanRule$Che$nextMove$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChessmanRule$Che$nextMove$lambda.prototype.constructor = Coroutine$ChessmanRule$Che$nextMove$lambda;
  Coroutine$ChessmanRule$Che$nextMove$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$yieldPosition = ChessmanRule$Che$nextMove$lambda$yieldPosition(this.local$closure$game, this.local$closure$owner);
            this.local$r = this.local$closure$current.r - 1 | 0;
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (this.local$r < 0) {
              this.state_0 = 6;
              continue;
            }
            this.state_0 = 3;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$r, this.local$closure$current.c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            if (this.result_0) {
              this.state_0 = 6;
              continue;
            } else {
              this.state_0 = 4;
              continue;
            }

          case 4:
            this.state_0 = 5;
            continue;
          case 5:
            this.local$r--;
            this.state_0 = 2;
            continue;
          case 6:
            this.local$r_0 = this.local$closure$current.r + 1 | 0;
            this.state_0 = 7;
            continue;
          case 7:
            if (this.local$r_0 >= 10) {
              this.state_0 = 11;
              continue;
            }
            this.state_0 = 8;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$r_0, this.local$closure$current.c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 8:
            if (this.result_0) {
              this.state_0 = 11;
              continue;
            } else {
              this.state_0 = 9;
              continue;
            }

          case 9:
            this.state_0 = 10;
            continue;
          case 10:
            this.local$r_0++;
            this.state_0 = 7;
            continue;
          case 11:
            this.local$c = this.local$closure$current.c - 1 | 0;
            this.state_0 = 12;
            continue;
          case 12:
            if (this.local$c < 0) {
              this.state_0 = 16;
              continue;
            }
            this.state_0 = 13;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$closure$current.r, this.local$c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 13:
            if (this.result_0) {
              this.state_0 = 16;
              continue;
            } else {
              this.state_0 = 14;
              continue;
            }

          case 14:
            this.state_0 = 15;
            continue;
          case 15:
            this.local$c--;
            this.state_0 = 12;
            continue;
          case 16:
            this.local$c_0 = this.local$closure$current.c + 1 | 0;
            this.state_0 = 17;
            continue;
          case 17:
            if (this.local$c_0 >= 9) {
              this.state_0 = 21;
              continue;
            }
            this.state_0 = 18;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$closure$current.r, this.local$c_0, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 18:
            if (this.result_0) {
              this.state_0 = 21;
              continue;
            } else {
              this.state_0 = 19;
              continue;
            }

          case 19:
            this.state_0 = 20;
            continue;
          case 20:
            this.local$c_0++;
            this.state_0 = 17;
            continue;
          case 21:
            return Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChessmanRule$Che$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ChessmanRule$Che$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  ChessmanRule$Che.prototype.nextMove_faldbz$ = function (current, game, owner) {
    return sequence(ChessmanRule$Che$nextMove$lambda(game, owner, current));
  };
  ChessmanRule$Che.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Che',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Che_instance = null;
  function ChessmanRule$Che_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Che_instance;
  }
  function ChessmanRule$Ma() {
    ChessmanRule$Ma_instance = this;
    ChessmanRule.call(this, 'Ma', 1, [Chessman$红马_getInstance(), Chessman$黑马_getInstance()]);
    this.top_0 = [new Position(-2, -1), new Position(-2, 1)];
    this.left_0 = [new Position(-1, -2), new Position(1, -2)];
    this.right_0 = [new Position(-1, 2), new Position(1, 2)];
    this.bottom_0 = [new Position(2, -1), new Position(2, 1)];
  }
  ChessmanRule$Ma.prototype.nextMove_faldbz$ = function (current, game, owner) {
    var step = [];
    if (game.gameBroad.get_vux9f0$(current.r - 1 | 0, current.c) == null) {
      var $receiver = step;
      var elements = this.top_0;
      step = $receiver.concat(elements);
    }if (game.gameBroad.get_vux9f0$(current.r + 1 | 0, current.c) == null) {
      var $receiver_0 = step;
      var elements_0 = this.bottom_0;
      step = $receiver_0.concat(elements_0);
    }if (game.gameBroad.get_vux9f0$(current.r, current.c - 1 | 0) == null) {
      var $receiver_1 = step;
      var elements_1 = this.left_0;
      step = $receiver_1.concat(elements_1);
    }if (game.gameBroad.get_vux9f0$(current.r, current.c + 1 | 0) == null) {
      var $receiver_2 = step;
      var elements_2 = this.right_0;
      step = $receiver_2.concat(elements_2);
    }return ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, step);
  };
  ChessmanRule$Ma.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Ma',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Ma_instance = null;
  function ChessmanRule$Ma_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Ma_instance;
  }
  function ChessmanRule$Shi() {
    ChessmanRule$Shi_instance = this;
    ChessmanRule.call(this, 'Shi', 2, [Chessman$红士_getInstance(), Chessman$黑士_getInstance()]);
    this.step_0 = [new Position(1, 1), new Position(1, -1), new Position(-1, -1), new Position(-1, 1)];
  }
  function ChessmanRule$Shi$nextMove$lambda(it) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2;
    tmp$ = it.c;
    if (3 <= tmp$ && tmp$ <= 5) {
      tmp$_0 = it.r;
      if (!(0 <= tmp$_0 && tmp$_0 <= 2)) {
        tmp$_1 = it.r;
        tmp$_2 = (7 <= tmp$_1 && tmp$_1 <= 9);
      } else
        tmp$_2 = true;
    } else
      tmp$_2 = false;
    return tmp$_2;
  }
  ChessmanRule$Shi.prototype.nextMove_faldbz$ = function (current, game, owner) {
    return filter(ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.step_0), ChessmanRule$Shi$nextMove$lambda);
  };
  ChessmanRule$Shi.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Shi',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Shi_instance = null;
  function ChessmanRule$Shi_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Shi_instance;
  }
  function ChessmanRule$Xiang() {
    ChessmanRule$Xiang_instance = this;
    ChessmanRule.call(this, 'Xiang', 3, [Chessman$红象_getInstance(), Chessman$黑象_getInstance()]);
    this.leftTop_0 = [new Position(-2, -2)];
    this.rightTop_0 = [new Position(-2, 2)];
    this.leftBottom_0 = [new Position(2, -2)];
    this.rightBottom_0 = [new Position(2, 2)];
  }
  function ChessmanRule$Xiang$nextMove$lambda(closure$owner) {
    return function (it) {
      return !closure$owner.not() && it.r > 4 || (closure$owner.not() && it.r <= 4);
    };
  }
  ChessmanRule$Xiang.prototype.nextMove_faldbz$ = function (current, game, owner) {
    var step = [];
    if (game.gameBroad.get_vux9f0$(current.r - 1 | 0, current.c - 1 | 0) == null) {
      var $receiver = step;
      var elements = this.leftTop_0;
      step = $receiver.concat(elements);
    }if (game.gameBroad.get_vux9f0$(current.r - 1 | 0, current.c + 1 | 0) == null) {
      var $receiver_0 = step;
      var elements_0 = this.rightTop_0;
      step = $receiver_0.concat(elements_0);
    }if (game.gameBroad.get_vux9f0$(current.r + 1 | 0, current.c - 1 | 0) == null) {
      var $receiver_1 = step;
      var elements_1 = this.leftBottom_0;
      step = $receiver_1.concat(elements_1);
    }if (game.gameBroad.get_vux9f0$(current.r + 1 | 0, current.c + 1 | 0) == null) {
      var $receiver_2 = step;
      var elements_2 = this.rightBottom_0;
      step = $receiver_2.concat(elements_2);
    }return filter(ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, step), ChessmanRule$Xiang$nextMove$lambda(owner));
  };
  ChessmanRule$Xiang.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Xiang',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Xiang_instance = null;
  function ChessmanRule$Xiang_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Xiang_instance;
  }
  function ChessmanRule$Jiang() {
    ChessmanRule$Jiang_instance = this;
    ChessmanRule.call(this, 'Jiang', 4, [Chessman$红将_getInstance(), Chessman$黑帅_getInstance()]);
    this.step_0 = [new Position(1, 0), new Position(0, 1), new Position(-1, 0), new Position(0, -1)];
  }
  function ChessmanRule$Jiang$nextMove$lambda(it) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2;
    tmp$ = it.c;
    if (3 <= tmp$ && tmp$ <= 5) {
      tmp$_0 = it.r;
      if (!(0 <= tmp$_0 && tmp$_0 <= 2)) {
        tmp$_1 = it.r;
        tmp$_2 = (7 <= tmp$_1 && tmp$_1 <= 9);
      } else
        tmp$_2 = true;
    } else
      tmp$_2 = false;
    return tmp$_2;
  }
  ChessmanRule$Jiang.prototype.nextMove_faldbz$ = function (current, game, owner) {
    return filter(ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.step_0), ChessmanRule$Jiang$nextMove$lambda);
  };
  ChessmanRule$Jiang.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Jiang',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Jiang_instance = null;
  function ChessmanRule$Jiang_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Jiang_instance;
  }
  function ChessmanRule$Bin() {
    ChessmanRule$Bin_instance = this;
    ChessmanRule.call(this, 'Bin', 5, [Chessman$红兵_getInstance(), Chessman$黑卒_getInstance()]);
    this.toLeftRight_0 = [new Position(0, 1), new Position(0, -1)];
    this.toTop_0 = [new Position(-1, 0)];
    this.toBottom_0 = [new Position(1, 0)];
    var $receiver = this.toTop_0;
    var elements = this.toLeftRight_0;
    this.toTopLeftRight_0 = $receiver.concat(elements);
    var $receiver_0 = this.toBottom_0;
    var elements_0 = this.toLeftRight_0;
    this.toBottomLeftRight_0 = $receiver_0.concat(elements_0);
  }
  ChessmanRule$Bin.prototype.nextMove_faldbz$ = function (current, game, owner) {
    var tmp$;
    if (!owner.not()) {
      tmp$ = current.r <= 4 ? ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.toTopLeftRight_0) : ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.toTop_0);
    } else {
      tmp$ = current.r > 4 ? ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.toBottomLeftRight_0) : ChessmanRule$Companion_getInstance().sequenceFromStep_0(current, this.toBottom_0);
    }
    return tmp$;
  };
  ChessmanRule$Bin.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Bin',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Bin_instance = null;
  function ChessmanRule$Bin_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Bin_instance;
  }
  function ChessmanRule$Pao() {
    ChessmanRule$Pao_instance = this;
    ChessmanRule.call(this, 'Pao', 6, [Chessman$红炮_getInstance(), Chessman$黑炮_getInstance()]);
  }
  function Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition(closure$game_0, closure$hasBlock_0, closure$owner_0, $receiver_0, r_0, c_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$game = closure$game_0;
    this.local$closure$hasBlock = closure$hasBlock_0;
    this.local$closure$owner = closure$owner_0;
    this.local$$receiver = $receiver_0;
    this.local$r = r_0;
    this.local$c = c_0;
  }
  Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition.prototype.constructor = Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition;
  Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            var target = this.local$closure$game.gameBroad.get_vux9f0$(this.local$r, this.local$c);
            if (this.local$closure$hasBlock.v && target != null) {
              if (target.owner !== this.local$closure$owner) {
                this.state_0 = 5;
                this.result_0 = this.local$$receiver.yield_11rb$(new Position(this.local$r, this.local$c), this);
                if (this.result_0 === COROUTINE_SUSPENDED)
                  return COROUTINE_SUSPENDED;
                continue;
              } else {
                this.state_0 = 6;
                continue;
              }
            } else {
              if (target != null) {
                this.local$closure$hasBlock.v = true;
                this.state_0 = 4;
                continue;
              } else {
                if (!this.local$closure$hasBlock.v) {
                  this.state_0 = 2;
                  this.result_0 = this.local$$receiver.yield_11rb$(new Position(this.local$r, this.local$c), this);
                  if (this.result_0 === COROUTINE_SUSPENDED)
                    return COROUTINE_SUSPENDED;
                  continue;
                } else {
                  this.state_0 = 3;
                  continue;
                }
              }
            }

          case 1:
            throw this.exception_0;
          case 2:
            this.state_0 = 3;
            continue;
          case 3:
            this.state_0 = 4;
            continue;
          case 4:
            this.state_0 = 7;
            continue;
          case 5:
            this.state_0 = 6;
            continue;
          case 6:
            return true;
          case 7:
            return false;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChessmanRule$Pao$nextMove$lambda$yieldPosition(closure$game_0, closure$hasBlock_0, closure$owner_0) {
    return function ($receiver_0, r_0, c_0, continuation_0, suspended) {
      var instance = new Coroutine$ChessmanRule$Pao$nextMove$lambda$yieldPosition(closure$game_0, closure$hasBlock_0, closure$owner_0, $receiver_0, r_0, c_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$ChessmanRule$Pao$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$game = closure$game_0;
    this.local$closure$owner = closure$owner_0;
    this.local$closure$current = closure$current_0;
    this.local$hasBlock = void 0;
    this.local$yieldPosition = void 0;
    this.local$r = void 0;
    this.local$r_0 = void 0;
    this.local$c = void 0;
    this.local$c_0 = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$ChessmanRule$Pao$nextMove$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChessmanRule$Pao$nextMove$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChessmanRule$Pao$nextMove$lambda.prototype.constructor = Coroutine$ChessmanRule$Pao$nextMove$lambda;
  Coroutine$ChessmanRule$Pao$nextMove$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$hasBlock = {v: false};
            this.local$yieldPosition = ChessmanRule$Pao$nextMove$lambda$yieldPosition(this.local$closure$game, this.local$hasBlock, this.local$closure$owner);
            this.local$hasBlock.v = false;
            this.local$r = this.local$closure$current.r - 1 | 0;
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (this.local$r < 0) {
              this.state_0 = 6;
              continue;
            }
            this.state_0 = 3;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$r, this.local$closure$current.c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            if (this.result_0) {
              this.state_0 = 6;
              continue;
            } else {
              this.state_0 = 4;
              continue;
            }

          case 4:
            this.state_0 = 5;
            continue;
          case 5:
            this.local$r--;
            this.state_0 = 2;
            continue;
          case 6:
            this.local$hasBlock.v = false;
            this.local$r_0 = this.local$closure$current.r + 1 | 0;
            this.state_0 = 7;
            continue;
          case 7:
            if (this.local$r_0 >= 10) {
              this.state_0 = 11;
              continue;
            }
            this.state_0 = 8;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$r_0, this.local$closure$current.c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 8:
            if (this.result_0) {
              this.state_0 = 11;
              continue;
            } else {
              this.state_0 = 9;
              continue;
            }

          case 9:
            this.state_0 = 10;
            continue;
          case 10:
            this.local$r_0++;
            this.state_0 = 7;
            continue;
          case 11:
            this.local$hasBlock.v = false;
            this.local$c = this.local$closure$current.c - 1 | 0;
            this.state_0 = 12;
            continue;
          case 12:
            if (this.local$c < 0) {
              this.state_0 = 16;
              continue;
            }
            this.state_0 = 13;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$closure$current.r, this.local$c, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 13:
            if (this.result_0) {
              this.state_0 = 16;
              continue;
            } else {
              this.state_0 = 14;
              continue;
            }

          case 14:
            this.state_0 = 15;
            continue;
          case 15:
            this.local$c--;
            this.state_0 = 12;
            continue;
          case 16:
            this.local$hasBlock.v = false;
            this.local$c_0 = this.local$closure$current.c + 1 | 0;
            this.state_0 = 17;
            continue;
          case 17:
            if (this.local$c_0 >= 9) {
              this.state_0 = 21;
              continue;
            }
            this.state_0 = 18;
            this.result_0 = this.local$yieldPosition(this.local$$receiver, this.local$closure$current.r, this.local$c_0, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 18:
            if (this.result_0) {
              this.state_0 = 21;
              continue;
            } else {
              this.state_0 = 19;
              continue;
            }

          case 19:
            this.state_0 = 20;
            continue;
          case 20:
            this.local$c_0++;
            this.state_0 = 17;
            continue;
          case 21:
            return Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChessmanRule$Pao$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ChessmanRule$Pao$nextMove$lambda(closure$game_0, closure$owner_0, closure$current_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  ChessmanRule$Pao.prototype.nextMove_faldbz$ = function (current, game, owner) {
    return sequence(ChessmanRule$Pao$nextMove$lambda(game, owner, current));
  };
  ChessmanRule$Pao.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Pao',
    interfaces: [ChessmanRule]
  };
  var ChessmanRule$Pao_instance = null;
  function ChessmanRule$Pao_getInstance() {
    ChessmanRule_initFields();
    return ChessmanRule$Pao_instance;
  }
  Object.defineProperty(ChessmanRule.prototype, 'productName', {
    get: function () {
      return this.productName_uxulvm$_0;
    }
  });
  function ChessmanRule$Companion() {
    ChessmanRule$Companion_instance = this;
    this.factory_0 = toFactory(ChessmanRule$values());
  }
  function ChessmanRule$Companion$nextMove$lambda(closure$game, closure$currentRow, closure$currentColumn, closure$chessman) {
    return function (f) {
      var newRow = f.component1()
      , newColumn = f.component2();
      var tmp$;
      return closure$game.gameBroad.contains_vux9f0$(newRow, newColumn) && (closure$currentRow !== newRow || closure$currentColumn !== newColumn) && !equals((tmp$ = closure$game.gameBroad.get_vux9f0$(newRow, newColumn)) != null ? tmp$.owner : null, closure$chessman.owner);
    };
  }
  ChessmanRule$Companion.prototype.nextMove_s5wel7$ = function (chessman, currentRow, currentColumn, game) {
    var rule = this.factory_0.create_11rb$(chessman);
    return filter(rule.nextMove_faldbz$(new Position(currentRow, currentColumn), game, chessman.owner), ChessmanRule$Companion$nextMove$lambda(game, currentRow, currentColumn, chessman));
  };
  function Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda(closure$step_0, closure$current_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$step = closure$step_0;
    this.local$closure$current = closure$current_0;
    this.local$$receiver = void 0;
    this.local$tmp$ = void 0;
    this.local$$receiver_0 = $receiver_0;
  }
  Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda.prototype.constructor = Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda;
  Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$$receiver = this.local$closure$step;
            this.local$tmp$ = 0;
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (this.local$tmp$ === this.local$$receiver.length) {
              this.state_0 = 5;
              continue;
            }
            var element = this.local$$receiver[this.local$tmp$];
            this.state_0 = 3;
            this.result_0 = this.local$$receiver_0.yield_11rb$(this.local$closure$current.offset_1r4877$(element), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            this.state_0 = 4;
            continue;
          case 4:
            ++this.local$tmp$;
            this.state_0 = 2;
            continue;
          case 5:
            return Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChessmanRule$Companion$sequenceFromStep$lambda(closure$step_0, closure$current_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ChessmanRule$Companion$sequenceFromStep$lambda(closure$step_0, closure$current_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  ChessmanRule$Companion.prototype.sequenceFromStep_0 = function (current, step) {
    return sequence(ChessmanRule$Companion$sequenceFromStep$lambda(step, current));
  };
  ChessmanRule$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var ChessmanRule$Companion_instance = null;
  function ChessmanRule$Companion_getInstance() {
    ChessmanRule_initFields();
    if (ChessmanRule$Companion_instance === null) {
      new ChessmanRule$Companion();
    }return ChessmanRule$Companion_instance;
  }
  ChessmanRule.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChessmanRule',
    interfaces: [Producible, Enum]
  };
  function ChessmanRule$values() {
    return [ChessmanRule$Che_getInstance(), ChessmanRule$Ma_getInstance(), ChessmanRule$Shi_getInstance(), ChessmanRule$Xiang_getInstance(), ChessmanRule$Jiang_getInstance(), ChessmanRule$Bin_getInstance(), ChessmanRule$Pao_getInstance()];
  }
  ChessmanRule.values = ChessmanRule$values;
  function ChessmanRule$valueOf(name) {
    switch (name) {
      case 'Che':
        return ChessmanRule$Che_getInstance();
      case 'Ma':
        return ChessmanRule$Ma_getInstance();
      case 'Shi':
        return ChessmanRule$Shi_getInstance();
      case 'Xiang':
        return ChessmanRule$Xiang_getInstance();
      case 'Jiang':
        return ChessmanRule$Jiang_getInstance();
      case 'Bin':
        return ChessmanRule$Bin_getInstance();
      case 'Pao':
        return ChessmanRule$Pao_getInstance();
      default:throwISE('No enum constant com.github.kchess.algorithm.ChessmanRule.' + name);
    }
  }
  ChessmanRule.valueOf_61zpoe$ = ChessmanRule$valueOf;
  function ChineseChess() {
    this.gameBroad = new ChineseChessBoard();
    this.currentPlayer = OwnerShip.Player1;
  }
  ChineseChess.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChineseChess',
    interfaces: []
  };
  function Position(r, c) {
    this.r = r;
    this.c = c;
  }
  Position.prototype.offset_1r4877$ = function (offset) {
    return new Position(this.r + offset.r | 0, this.c + offset.c | 0);
  };
  Position.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Position',
    interfaces: []
  };
  Position.prototype.component1 = function () {
    return this.r;
  };
  Position.prototype.component2 = function () {
    return this.c;
  };
  Position.prototype.copy_vux9f0$ = function (r, c) {
    return new Position(r === void 0 ? this.r : r, c === void 0 ? this.c : c);
  };
  Position.prototype.toString = function () {
    return 'Position(r=' + Kotlin.toString(this.r) + (', c=' + Kotlin.toString(this.c)) + ')';
  };
  Position.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.r) | 0;
    result = result * 31 + Kotlin.hashCode(this.c) | 0;
    return result;
  };
  Position.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.r, other.r) && Kotlin.equals(this.c, other.c)))));
  };
  function ChineseChessAction(chessman, x, y, newX, newY) {
    this.chessman_0 = chessman;
    this.x_0 = x;
    this.y_0 = y;
    this.newX_0 = newX;
    this.newY_0 = newY;
    this.eat_0 = null;
  }
  ChineseChessAction.prototype.run_11rb$ = function (context) {
    context.gameBroad.set_hbm46t$(this.x_0, this.y_0, null);
    this.eat_0 = context.gameBroad.get_vux9f0$(this.newX_0, this.newY_0);
    context.gameBroad.set_hbm46t$(this.newX_0, this.newY_0, this.chessman_0);
  };
  ChineseChessAction.prototype.undo_11rb$ = function (context) {
    context.gameBroad.set_hbm46t$(this.newX_0, this.newY_0, this.eat_0);
    context.gameBroad.set_hbm46t$(this.x_0, this.y_0, this.chessman_0);
  };
  ChineseChessAction.prototype.toString = function () {
    return 'Move ' + this.chessman_0 + ' from [' + this.x_0 + ',' + this.y_0 + '] to [' + this.newX_0 + ',' + this.newY_0 + ']';
  };
  ChineseChessAction.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChineseChessAction',
    interfaces: [GameAction]
  };
  function ChineseChessBoard() {
    ChineseChessBoard$Companion_getInstance();
    this.gameBoard_lirlmj$_0 = this.gameBoard_lirlmj$_0;
    this.reset();
  }
  Object.defineProperty(ChineseChessBoard.prototype, 'gameBoard_0', {
    get: function () {
      if (this.gameBoard_lirlmj$_0 == null)
        return throwUPAE('gameBoard');
      return this.gameBoard_lirlmj$_0;
    },
    set: function (gameBoard) {
      this.gameBoard_lirlmj$_0 = gameBoard;
    }
  });
  ChineseChessBoard.prototype.reset = function () {
    this.gameBoard_0 = [[Chessman$黑车_getInstance(), Chessman$黑马_getInstance(), Chessman$黑象_getInstance(), Chessman$黑士_getInstance(), Chessman$黑帅_getInstance(), Chessman$黑士_getInstance(), Chessman$黑象_getInstance(), Chessman$黑马_getInstance(), Chessman$黑车_getInstance()], [null, null, null, null, null, null, null, null, null], [null, Chessman$黑炮_getInstance(), null, null, null, null, null, Chessman$黑炮_getInstance(), null], [Chessman$黑卒_getInstance(), null, Chessman$黑卒_getInstance(), null, Chessman$黑卒_getInstance(), null, Chessman$黑卒_getInstance(), null, Chessman$黑卒_getInstance()], [null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null], [Chessman$红兵_getInstance(), null, Chessman$红兵_getInstance(), null, Chessman$红兵_getInstance(), null, Chessman$红兵_getInstance(), null, Chessman$红兵_getInstance()], [null, Chessman$红炮_getInstance(), null, null, null, null, null, Chessman$红炮_getInstance(), null], [null, null, null, null, null, null, null, null, null], [Chessman$红车_getInstance(), Chessman$红马_getInstance(), Chessman$红象_getInstance(), Chessman$红士_getInstance(), Chessman$红将_getInstance(), Chessman$红士_getInstance(), Chessman$红象_getInstance(), Chessman$红马_getInstance(), Chessman$红车_getInstance()]];
  };
  ChineseChessBoard.prototype.reset_r9etqj$ = function (board) {
    if (board.length !== 10) {
      throw IllegalArgumentException_init('board.size must be 10');
    }var tmp$, tmp$_0;
    var index = 0;
    for (tmp$ = 0; tmp$ !== board.length; ++tmp$) {
      var item = board[tmp$];
      var index_0 = (tmp$_0 = index, index = tmp$_0 + 1 | 0, tmp$_0);
      if (item.length !== 9) {
        throw IllegalArgumentException_init('board[' + index_0 + '].size must be ' + '9');
      }}
    this.gameBoard_0 = board;
  };
  ChineseChessBoard.prototype.forEach = function (yield_0) {
    var newLine = {v: false};
    var $receiver = this.gameBoard_0;
    var tmp$;
    for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
      var element = $receiver[tmp$];
      var tmp$_0;
      for (tmp$_0 = 0; tmp$_0 !== element.length; ++tmp$_0) {
        var element_0 = element[tmp$_0];
        yield_0(newLine.v, element_0);
        newLine.v = false;
      }
      newLine.v = true;
    }
  };
  function Coroutine$ChineseChessBoard$iterator$lambda(this$ChineseChessBoard_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$this$ChineseChessBoard = this$ChineseChessBoard_0;
    this.local$$receiver = void 0;
    this.local$tmp$ = void 0;
    this.local$index = void 0;
    this.local$item = void 0;
    this.local$r = void 0;
    this.local$tmp$_1 = void 0;
    this.local$index_0 = void 0;
    this.local$$receiver_0 = $receiver_0;
  }
  Coroutine$ChineseChessBoard$iterator$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChineseChessBoard$iterator$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChineseChessBoard$iterator$lambda.prototype.constructor = Coroutine$ChineseChessBoard$iterator$lambda;
  Coroutine$ChineseChessBoard$iterator$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$$receiver = this.local$this$ChineseChessBoard.gameBoard_0;
            var tmp$_0;
            this.local$index = 0;
            this.local$tmp$ = 0;
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (this.local$tmp$ === this.local$$receiver.length) {
              this.state_0 = 9;
              continue;
            }
            this.local$item = this.local$$receiver[this.local$tmp$];
            this.local$r = (tmp$_0 = this.local$index, this.local$index = tmp$_0 + 1 | 0, tmp$_0);
            var tmp$_0_0;
            this.local$index_0 = 0;
            this.local$tmp$_1 = 0;
            this.state_0 = 3;
            continue;
          case 3:
            if (this.local$tmp$_1 === this.local$item.length) {
              this.state_0 = 7;
              continue;
            }
            var item = this.local$item[this.local$tmp$_1];
            var c = (tmp$_0_0 = this.local$index_0, this.local$index_0 = tmp$_0_0 + 1 | 0, tmp$_0_0);
            if (item != null) {
              this.state_0 = 4;
              this.result_0 = this.local$$receiver_0.yield_11rb$(new ChessmanWithPosition(item, this.local$r, c), this);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              continue;
            } else {
              this.state_0 = 5;
              continue;
            }

          case 4:
            this.state_0 = 5;
            continue;
          case 5:
            this.state_0 = 6;
            continue;
          case 6:
            ++this.local$tmp$_1;
            this.state_0 = 3;
            continue;
          case 7:
            this.state_0 = 8;
            continue;
          case 8:
            ++this.local$tmp$;
            this.state_0 = 2;
            continue;
          case 9:
            return Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChineseChessBoard$iterator$lambda(this$ChineseChessBoard_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ChineseChessBoard$iterator$lambda(this$ChineseChessBoard_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  ChineseChessBoard.prototype.iterator = function () {
    return iterator(ChineseChessBoard$iterator$lambda(this));
  };
  ChineseChessBoard.prototype.contains_vux9f0$ = function (row, column) {
    return 0 <= row && row < 10 && (0 <= column && column < 9);
  };
  ChineseChessBoard.prototype.contains_1r4877$ = function (pos) {
    return this.contains_vux9f0$(pos.r, pos.c);
  };
  ChineseChessBoard.prototype.get_vux9f0$ = function (row, column) {
    if (this.contains_vux9f0$(row, column))
      return this.gameBoard_0[row][column];
    return null;
  };
  ChineseChessBoard.prototype.set_hbm46t$ = function (row, column, chessman) {
    if (this.contains_vux9f0$(row, column)) {
      this.gameBoard_0[row][column] = chessman;
    }};
  function ChineseChessBoard$Companion() {
    ChineseChessBoard$Companion_instance = this;
    this.ROW_SIZE = 10;
    this.COLUMN_SIZE = 9;
  }
  ChineseChessBoard$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var ChineseChessBoard$Companion_instance = null;
  function ChineseChessBoard$Companion_getInstance() {
    if (ChineseChessBoard$Companion_instance === null) {
      new ChineseChessBoard$Companion();
    }return ChineseChessBoard$Companion_instance;
  }
  ChineseChessBoard.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChineseChessBoard',
    interfaces: [Iterable]
  };
  function ChessmanWithPosition(chessman, row, column) {
    this.chessman = chessman;
    this.row = row;
    this.column = column;
  }
  ChessmanWithPosition.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChessmanWithPosition',
    interfaces: []
  };
  ChessmanWithPosition.prototype.component1 = function () {
    return this.chessman;
  };
  ChessmanWithPosition.prototype.component2 = function () {
    return this.row;
  };
  ChessmanWithPosition.prototype.component3 = function () {
    return this.column;
  };
  ChessmanWithPosition.prototype.copy_5ce7f0$ = function (chessman, row, column) {
    return new ChessmanWithPosition(chessman === void 0 ? this.chessman : chessman, row === void 0 ? this.row : row, column === void 0 ? this.column : column);
  };
  ChessmanWithPosition.prototype.toString = function () {
    return 'ChessmanWithPosition(chessman=' + Kotlin.toString(this.chessman) + (', row=' + Kotlin.toString(this.row)) + (', column=' + Kotlin.toString(this.column)) + ')';
  };
  ChessmanWithPosition.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.chessman) | 0;
    result = result * 31 + Kotlin.hashCode(this.row) | 0;
    result = result * 31 + Kotlin.hashCode(this.column) | 0;
    return result;
  };
  ChessmanWithPosition.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.chessman, other.chessman) && Kotlin.equals(this.row, other.row) && Kotlin.equals(this.column, other.column)))));
  };
  function ChineseChessSearch() {
    GameActionSearch.call(this);
  }
  ChineseChessSearch.prototype.evaluate_nw8la0$ = function (context, player) {
    var tmp$;
    var accumulator = 0;
    tmp$ = context.gameBroad.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      var value = accumulator;
      var chessman = element.component1()
      , row = element.component2()
      , column = element.component3();
      accumulator = value + ChessmanEvaluator$Companion_getInstance().evaluate_jght4t$(chessman, row, column, player) | 0;
    }
    return accumulator;
  };
  function ChineseChessSearch$nextMove$lambda$lambda$lambda(closure$chessman, closure$row, closure$column) {
    return function (f) {
      var newRow = f.component1()
      , newColumn = f.component2();
      return new ChineseChessAction(closure$chessman, closure$row, closure$column, newRow, newColumn);
    };
  }
  function Coroutine$ChineseChessSearch$nextMove$lambda(closure$context_0, closure$player_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$context = closure$context_0;
    this.local$closure$player = closure$player_0;
    this.local$tmp$ = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$ChineseChessSearch$nextMove$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ChineseChessSearch$nextMove$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ChineseChessSearch$nextMove$lambda.prototype.constructor = Coroutine$ChineseChessSearch$nextMove$lambda;
  Coroutine$ChineseChessSearch$nextMove$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$tmp$ = this.local$closure$context.gameBroad.iterator();
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (!this.local$tmp$.hasNext()) {
              this.state_0 = 5;
              continue;
            }
            var element = this.local$tmp$.next();
            var closure$player = this.local$closure$player;
            var closure$context = this.local$closure$context;
            var chessman = element.component1()
            , row = element.component2()
            , column = element.component3();
            if (chessman.owner === closure$player) {
              this.state_0 = 3;
              this.result_0 = this.local$$receiver.yieldAll_swo9gw$(map(ChessmanRule$Companion_getInstance().nextMove_s5wel7$(chessman, row, column, closure$context), ChineseChessSearch$nextMove$lambda$lambda$lambda(chessman, row, column)), this);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              continue;
            } else {
              this.state_0 = 4;
              continue;
            }

          case 3:
            this.state_0 = 4;
            continue;
          case 4:
            this.state_0 = 2;
            continue;
          case 5:
            return Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function ChineseChessSearch$nextMove$lambda(closure$context_0, closure$player_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ChineseChessSearch$nextMove$lambda(closure$context_0, closure$player_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  ChineseChessSearch.prototype.nextMove_nw8la0$ = function (context, player) {
    return sequence(ChineseChessSearch$nextMove$lambda(context, player));
  };
  ChineseChessSearch.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChineseChessSearch',
    interfaces: [GameActionSearch]
  };
  function Factory() {
  }
  Factory.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Factory',
    interfaces: []
  };
  function Producible() {
  }
  Producible.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Producible',
    interfaces: []
  };
  function toFactory$ObjectLiteral(closure$map) {
    this.closure$map = closure$map;
  }
  toFactory$ObjectLiteral.prototype.create_11rb$ = function (name) {
    return ensureNotNull(this.closure$map.get_11rb$(name));
  };
  toFactory$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [Factory]
  };
  function toFactory($receiver) {
    var map = LinkedHashMap_init();
    var tmp$;
    for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
      var element = $receiver[tmp$];
      var $receiver_0 = element.productName;
      var tmp$_0;
      for (tmp$_0 = 0; tmp$_0 !== $receiver_0.length; ++tmp$_0) {
        var element_0 = $receiver_0[tmp$_0];
        map.put_xwzc9p$(element_0, element);
      }
    }
    return new toFactory$ObjectLiteral(map);
  }
  function ChineseChess_0() {
    return new ChineseChess();
  }
  Object.defineProperty(Chessman, '\u7EA2\u8F66', {
    get: Chessman$红车_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u9A6C', {
    get: Chessman$红马_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u8C61', {
    get: Chessman$红象_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u58EB', {
    get: Chessman$红士_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u5C06', {
    get: Chessman$红将_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u70AE', {
    get: Chessman$红炮_getInstance
  });
  Object.defineProperty(Chessman, '\u7EA2\u5175', {
    get: Chessman$红兵_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u8F66', {
    get: Chessman$黑车_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u9A6C', {
    get: Chessman$黑马_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u8C61', {
    get: Chessman$黑象_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u58EB', {
    get: Chessman$黑士_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u5E05', {
    get: Chessman$黑帅_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u70AE', {
    get: Chessman$黑炮_getInstance
  });
  Object.defineProperty(Chessman, '\u9ED1\u5352', {
    get: Chessman$黑卒_getInstance
  });
  var package$com = _.com || (_.com = {});
  var package$github = package$com.github || (package$com.github = {});
  var package$kchess = package$github.kchess || (package$github.kchess = {});
  var package$algorithm = package$kchess.algorithm || (package$kchess.algorithm = {});
  package$algorithm.Chessman = Chessman;
  Object.defineProperty(ChessmanEvaluator, 'Che', {
    get: ChessmanEvaluator$Che_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Ma', {
    get: ChessmanEvaluator$Ma_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Xiang', {
    get: ChessmanEvaluator$Xiang_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Shi', {
    get: ChessmanEvaluator$Shi_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'jiang', {
    get: ChessmanEvaluator$jiang_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Pao', {
    get: ChessmanEvaluator$Pao_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Zu', {
    get: ChessmanEvaluator$Zu_getInstance
  });
  Object.defineProperty(ChessmanEvaluator, 'Companion', {
    get: ChessmanEvaluator$Companion_getInstance
  });
  package$algorithm.ChessmanEvaluator = ChessmanEvaluator;
  Object.defineProperty(ChessmanRule, 'Che', {
    get: ChessmanRule$Che_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Ma', {
    get: ChessmanRule$Ma_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Shi', {
    get: ChessmanRule$Shi_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Xiang', {
    get: ChessmanRule$Xiang_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Jiang', {
    get: ChessmanRule$Jiang_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Bin', {
    get: ChessmanRule$Bin_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Pao', {
    get: ChessmanRule$Pao_getInstance
  });
  Object.defineProperty(ChessmanRule, 'Companion', {
    get: ChessmanRule$Companion_getInstance
  });
  package$algorithm.ChessmanRule = ChessmanRule;
  package$algorithm.ChineseChess = ChineseChess;
  package$algorithm.Position = Position;
  package$algorithm.ChineseChessAction = ChineseChessAction;
  Object.defineProperty(ChineseChessBoard, 'Companion', {
    get: ChineseChessBoard$Companion_getInstance
  });
  package$algorithm.ChineseChessBoard = ChineseChessBoard;
  package$algorithm.ChessmanWithPosition = ChessmanWithPosition;
  package$algorithm.ChineseChessSearch = ChineseChessSearch;
  package$algorithm.Factory = Factory;
  package$algorithm.Producible = Producible;
  package$algorithm.toFactory_alwag$ = toFactory;
  _.ChineseChess = ChineseChess_0;
  Kotlin.defineModule('kchess-algorithm-chinesechess', _);
  return _;
}));

//# sourceMappingURL=kchess-algorithm-chinesechess.js.map
