CREATE TABLE IF NOT EXISTS PRODUCT(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    productName TEXT,
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS REVIEW (
    reviewId INT PRIMARY KEY AUTO_INCREMENT,
    reviewContent TEXT ,
    rating INT ,
    productId INT,
    FOREIGN KEY(productId) REFERENCES PRODUCT(productId)
);