var arguments = process.argv;

var url = arguments[2];
var fileName = "";
try {
    fileName = url.split('/');
    let index = fileName.indexOf("problems");
    if( index === -1){
        throw new Error("Please recheck the file Name");   
    }
    fileName = "GFG."+fileName[fileName.indexOf('problems')+1]+".java"
    console.log(fileName);
    var fs = require('fs');
    fs.writeFile(fileName, content, function (err) {
    if (err) throw err;
    console.log('Saved!');
    });
}
catch( err ){
    console.error(err.message);
}
