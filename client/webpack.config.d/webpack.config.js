config.devServer = {
    ...config.devServer,
    port: 9000,
    historyApiFallback: {
        index: 'index.html'
    }
}