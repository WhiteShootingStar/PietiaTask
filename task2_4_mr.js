var mapFunction=function(){

var key= this.nationality
var value={
count:1,
weight: parseFloat(this.weight),
height:parseFloat(this.height),
BMI:0,
BMI_min:99999,
BMI_max:-1
};

emit(key,value);
};

var reduceFunction=function(key,values){
	
var result={
		count:0,
		weight:0,
		height:0,
		BMI:0,
		BMI_min:99999,
		BMI_max:-1
		
};

for(var i = 0; i< values.length;i++){
	result.count+=1;
	result.weight+=values[i].weight;
	result.height+=values[i].height;
	var BMI_temp=values[i].weight /(values[i].height*values[i].height);
	result.BMI+=BMI_temp;
	if(BMI_temp<result.BMI_min){
		result.BMI_min=BMI_temp;
	}
	
	if(BMI_temp>result.BMI_max){
		result.BMI_max=BMI_temp;
	}
}

return result;
};

var finalizeFunction=function(key, reducedValue){
	
	reducedValue.avgBMI=reducedValue.BMI/reducedValue.count;
	
	return reducedValue;
};

printjson(db.people.mapReduce(mapFunction,reduceFunction, {out:{inline:1}, finalize:finalizeFunction})  );