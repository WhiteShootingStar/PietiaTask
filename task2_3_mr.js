var mapFunction=function(){

var key= this.job
var value={
count:1
};

emit(key,value);
};

var reduceFunction=function(key,values){
	
var result={
		count:0,	
};

for(var i = 0; i< values.length;i++){
result.count+=1;}
	
if(result.count===1){

return result;}
};



printjson(db.people.mapReduce(mapFunction,reduceFunction, {out:{inline:1}})  );