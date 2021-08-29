const oldDevServer = config.devServer;
config.devServer = {
    ...oldDevServer,
    port: 9000
}