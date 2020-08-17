const path = require('path');

module.exports = {
  // index: path.resolve(__dirname, '../../src/main/resources/static/index.html'),
  indexPath: "../static/index.html",
  outputDir: path.resolve(__dirname, "../src/main/resources/static"),
  runtimeCompiler: true,
  // productionSourceMap: false,
  lintOnSave: false,
  devServer: {
    proxy: { // proxyTable 설정
      '/api': {
        target: 'http://localhost:8282',
        // changeOrigin: true
      }
    }
  },
  publicPath: '/',
  // publicPath: process.env.NODE_ENV === 'production'
  //     ? '/sipotal-0.0.1-SNAPSHOT/'
  //     : '/'
} 