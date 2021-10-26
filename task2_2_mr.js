var mapFunction=function(){

var keys= this.credit;
var value={
	count:1,
	sum:0
};

for (var i=0; i<keys.length;i++){
	value.sum=parceFloat(keys[i].balance);
	emit(keys[i].currency,value);
}

};

var reduceFunction=function(key,values){
	
var result={
		count:0,
		sum:0
		
};

for(var i = 0; i< values.length;i++){
	result.count+=1;
	result.sum+=values[i].sum;
	
}

return result;
};



printjson(db.people.mapReduce(mapFunction,reduceFunction, {out:{inline:1}})  );