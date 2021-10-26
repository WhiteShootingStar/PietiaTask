var mapFunction=function(){

var key= this.sex
var value={
count:1,
weight: parceFloat(this.weight),
height:parceFloat(this.height)
};

emit(key,value);
};

var reduceFunction=function(key,values){
	
var result={
		count:0,
		weight:0,
		height:0
		
};

for(var i = 0; i< values.length;i++){
	result.count+=1;
	result.weight+=values[i].weight;
	result.height+=values[i].height;
}

return result;
};

var finalizeFunction=function(key, reducedValue){
	reducedValue.avgWeight=reducedValue.weight/reducedValue.count;
	reducedValue.avgHeight=reducedValue.height/reducedValue.count;
	return reducedValue;
};

printjson(db.people.mapReduce(mapFunction,reduceFunction, {out:{inline:1}, finalize:finalizeFunction})  );