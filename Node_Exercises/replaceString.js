
const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.question('Please enter a string: ', (answer) => {
	constStr = answer;
	for (var i = 0; i < constStr.length; i++) {
		firstChar = constStr[0];
		constStr = constStr + firstChar;
		constStr = constStr.substr(1);
		console.log(constStr);
	}
	rl.close();
})

