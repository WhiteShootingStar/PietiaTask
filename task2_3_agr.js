printjson(db.people.aggregate([

{$group: { _id: "$job"}  }
]).toArray());

printjson(db.people.findOne({job:"Safety Technician II"}));
