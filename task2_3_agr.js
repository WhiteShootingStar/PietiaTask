printjson(db.people.aggregate([

{$group: { _id: "$job"}  }
]));

printjson(db.people.findOne({job:"Safety Technician II"}));
