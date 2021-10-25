printjson(db.people.aggregate([

{$unwind: "$credit"} ,

{$group: { _id: "$credit.currency", total_sum: {$sum: {$toDouble:"$credit.balance" } } }}
]));
