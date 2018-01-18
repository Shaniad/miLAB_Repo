const MongoClient = require('mongodb').MongoClient;
const MONGO_URL = "mongodb://localhost:27017/music_songs";
const express = require('express');

let app = express();

MongoClient.connect(MONGO_URL, (err, db) => {
    if (err) {
        console.error(err);
        return;
    }

    let dbo = db.db("music_songs");
    let collection = dbo.collection('songs');


    function print(object, res){
        res.write(`id: ${object._id}\n`);
        res.write(`song_name: ${object.song_name}\n`);
        res.write(`artist: ${object.artist}\n`);
        res.write(`\n`);
    }
    // create new collection in "songs_db"
    app.get('/create/:newCollection'), (req, res) => {
        let collectionToAdd = req.params.newCollection
        dbo.createCollection(collectionToAdd, function(err, res){
            if (err) throw err;
            console.log("collection created!");
            db.close();
        });
    }

    // read song details
    app .get('readSong/:songName'), (req, res) => {
        let songToFind = req.params.songName;
        collection.findOne({song_name: songToFind}, function(err, document) {
            if (err || !document){
                res.write("an error occurred while searching the song");
            }
            else{
                printSong(document, res);
                res.end();
            }
        });
    }

    // read artist details
    app.get('readArtist/:artistName'), (req, res) => {
        let artistToFind = req.params.artistName;
        collection.find({artist: artistToFind}).toArray(function(err, result) {
            if (err || !document){
                res.write("an error occurred while searching the artist");
            }
            else{
                result.forEach(j => printSong(j, res));
                res.end();
            }
        });
    }

    // delete object by id
    app.get('delete/:id'), function(req, res){
        let idToDelete = req.params.id;
        collection.deleteOne({_id: idToDelete}, function(err, res){
            if (err) throw err;
            console.log("1 document deleted");
        });
    }    
});
