db.Customers.find({})
    .projection({})
    .sort({_id:-1})
    .limit(100)

db.Products.find({})
    .projection({})
    .sort({_id:-1})
    .limit(100)
