printjson(db.people.aggregate([

{ $project : {  nationality:1, BMI: {$divide: [ {$toDouble:'$weight'}, {$multiply : [ {$toDouble: '$height'}, {$toDouble: '$height'} ]}] } } } ,

{$group: { _id: "$nationality", avg_BMI: {$avg : "$BMI"  } ,  max_BMI:{$max:"$BMI"}, min_BMI : {$min:"$BMI"}}}

]).toArray());
