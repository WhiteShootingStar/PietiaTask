printjson(db.people.aggregate([

{$match: {sex:"Female", nationality :"Poland"}},
{$unwind: "$credit"} ,

{$group: { _id: "$credit.currency", total_sum: {$sum: {$toDouble:"$credit.balance" } } }}
]));
