const express = require('express');
const datetime = require('node-datetime');
const fs = require('fs');
let app = express();

app.get('/getTime', (req, res) => {
	let server_time = datetime.create();
	res.send('Server time is: ' + server_time.format('H:M:S d/m/y'));
});

app.get('/getFile', (req, res) => {
  let file = req.query.filename || "<unknown>";
  fs.readFile(file, "utf8", (err, data) => {
  	if(err){
  		console.error(err);
  		return;
  	}
  	res.send(data);
  });
});

app.listen(4000, () => {
	console.log('Listening on port 4000');
});