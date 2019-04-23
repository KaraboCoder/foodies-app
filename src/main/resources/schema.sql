/* Create user profile schema */
CREATE TABLE IF NOT EXISTS userprofiles(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT ,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

/* Create recipe schema */
CREATE TABLE IF NOT EXISTS recipes(
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    OwnerId BIGINT(20) NOT NULL DEFAULT 0,
    description TEXT,
    instructions LONGTEXT NOT NULL,
    displayPictureUrl  TEXT,
    timeToPrepare VARCHAR(100),
    difficultyLevel VARCHAR(50)
);

/* Create ingredient schema */
CREATE TABLE IF NOT EXISTS ingredients(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    UnitOfMeasurement VARCHAR(25) NOT NULL,
    Quantity Number(10) NOT NULL,
    EstimatedPrice number(10),
    MoreInfo TEXT;
    recipe BIGINT(20) REFERENCES recipes(id)
);

/* Create categories schema */
CREATE TABLE IF NOT EXISTS recipeCategories(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    Description TEXT,
    recipe BIGINT(20) REFERENCES recipes(id)
);


