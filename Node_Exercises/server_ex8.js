const express = require('express');
const fs = require('fs');

let app = express();

app.get('/files/:filename', (req, res) => {
  let file = req.params.filename
  const readStream = fs.createReadStream(file);
  readStream.pipe(res);
});

app.listen(4000, () => {
	console.log('Listening on port 4000');
});