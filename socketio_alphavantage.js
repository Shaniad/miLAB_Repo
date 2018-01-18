const express = require('express');
const alphavantage = require('alphavantage')({key: 'PBWZJ1I4NRM4DGVR'});
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io').listen(server);
const port = process.env.PORT || 2222;

server.listen(port, function () {
	console.log(`Server listening at port ${port}`);
});


io.on('connection', function (socket) {
	let stock = null;
	socket.on('sendingStockName', (name) =>{
		stock = name;
		console.log(`Stock is: ${stock}`);
	});
});
