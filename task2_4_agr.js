printjson(db.people.aggregate([

{ $project : {  nationality:1, BMI: {$divide:[ {$add :[ {$toDouble:"$weight"}, {$toDouble: "$height"}  ]},2] } } } ,

{$group: { _id: "$nationality", avg_BMI: {$avg : "$BMI"  } ,  max_BMI:{$max:"$BMI"}, min_BMI : {$min:"$BMI"}}}

]));