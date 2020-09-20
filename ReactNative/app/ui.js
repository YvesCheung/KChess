import {Dimensions} from 'react-native';

const width = Dimensions.get('window').width
const height = Dimensions.get('window').height
const basePx = 375

export default {
    screenWidth: width,
    screenHeight: height,
    px2dp: (px) => {
        return px * width / basePx
    }
}

