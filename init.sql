CREATE TABLE characters
(
    id         TEXT PRIMARY KEY,
    firstname  TEXT NOT NULL,
    lastname   TEXT NOT NULL,
    occupation TEXT,
    motto      TEXT,
    imageUrl   TEXT
);

INSERT INTO characters (id, firstname, lastname, occupation, imageUrl, motto)
VALUES ('b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3', 'SpongeBob', 'SquarePants', 'Fry Cook',
        'https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/SpongeBob_SquarePants_character.svg/440px-SpongeBob_SquarePants_character.svg.png', 'I’m ready!'),
       ('b0d4890b-7ff3-4f00-b34a-230dc5b94de5', 'Patrick', 'Star', 'Unemployed', 'https://upload.wikimedia.org/wikipedia/en/thumb/3/33/Patrick_Star.svg/440px-Patrick_Star.svg.png',
        'Is mayonnaise an instrument?'),
       ('b9f1e582-6b4b-4e56-a509-d545e6c8a81a', 'Squidward', 'Tentacles', 'Cashier',
        'https://upload.wikimedia.org/wikipedia/en/thumb/7/79/Squidward_Tentacles_%28fair_use%29.svg/300px-Squidward_Tentacles_%28fair_use%29.svg.png', 'I hate everyone.'),
       ('cbe4b2d8-e9c0-4d85-b2d1-b8a76d2a1155', 'Mr.', 'Krabs', 'Restaurant Owner', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f8/Mr._Krabs.svg/440px-Mr._Krabs.svg.png',
        'Money, money, money!'),
       ('f48d6f7c-5090-4d9e-9f2c-6c1b5c305b46', 'Sandy', 'Cheeks', 'Scientist', 'https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Sandy_Cheeks.svg/440px-Sandy_Cheeks.svg.png',
        'Texas is a state of mind!'),
       ('8e3d4c5e-1a2c-4267-bc43-0b2b52d897e0', 'Gary', 'The Snail', 'Pet', 'https://youtooz.com/cdn/shop/products/sb-stickie-gary_501x486trim_min-2tll.png?v=1671060021', 'Meow!'),
       ('c63f7c4b-e4ab-4b53-a8f8-f4e59d84b8e2', 'Mrs.', 'Puff', 'Boating School Teacher',
        'https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Mrs._Puff.svg/640px-Mrs._Puff.svg.png', 'You’re going to kill me!'),
       ('1a9d9c79-d7c7-4c04-8dc8-79b84d9d69f4', 'Larry', 'The Lobster', 'Lifeguard', 'https://i.redd.it/good-ole-larry-the-lobster-v0-151ufy3z9ktd1.jpg?width=1230&format=pjpg&auto=webp&s=172ff45eed4d3a3846799fdaf468f8a937b38cd4',
        'Let’s get buff!'),
       ('e2e7dff2-9a6e-45f1-b2b1-5c0d4c3e7d82', 'Bubble', 'Bass', 'Food Critic', 'https://youtooz.com/cdn/shop/files/38u7n1u5h1.png?v=1726153323',
        'I’m not a cook!'),
       ('7c8b1ee7-fc31-4b38-bf8a-91d2548be8b4', 'Karen', 'Plankton', 'Computer', 'https://ih1.redbubble.net/image.4241975195.7424/flat,750x,075,f-pad,750x1000,f8f8f8.jpg',
        'I’m not just a computer, I’m a lifestyle!'),
       ('c5c7fc15-3829-4e86-84c4-dae7fa923e69', 'Pearl', 'Krabs', 'Teenager', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk23cjihvjBieIFnvsgSeNpKqqp87lV9voyw&s',
        'Like, whatever!'),
       ('8d063f68-e826-478f-95b3-0eb2e1d08109', 'Sheldon', 'Plankton', 'Inventor', 'https://ih1.redbubble.net/image.3710449734.8112/raf,750x1000,075,t,FFFFFF:97ab1c12de.jpg',
        'I’m a genius!'),
       ('239f2e80-f3e0-45af-89c1-61b23a6f50ef', 'Merman', 'Man', 'Hero', 'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/d4abc94a-f39d-409f-8ae1-4f8a1e5b0e36/dfze1uf-77e9443f-5242-4f9b-8720-73ee267dd571.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2Q0YWJjOTRhLWYzOWQtNDA5Zi04YWUxLTRmOGExZTViMGUzNlwvZGZ6ZTF1Zi03N2U5NDQzZi01MjQyLTRmOWItODcyMC03M2VlMjY3ZGQ1NzEucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.fuWL-DKcItaYALtM8s-BDcQ0e7CJlJeeQqxut53Jfb4',
        'I’m here to save the day!'),
       ('3b0d31be-d3af-4096-b46e-e8d813e52c41', 'The', 'Flying Dutchman', 'Ghost',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS_I6reCZUR_Wa56Smy1kO33Fn8PzPnKXCQw&s', 'Arrr, I be the Flying Dutchman!'),
       ('a3280339-27d7-44eb-9b80-bdbd35d6407e', 'Fred', 'The Fish', 'Customer', 'https://static.wikia.nocookie.net/spongebob/images/c/cb/Fred_%28Incidental_1%29.png/revision/latest/thumbnail/width/360/height/450?cb=20230402175209',
        'My leg!'),
       ('62389e95-2e61-4f37-a9a3-bb1de3a251c8', 'Bubbles', 'The Clownfish', 'Clown', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIJJJjI0Tqbsd5zqXXDFUGjJPj1bq4mDDq3oMwBm2UgT2IhmLVWxKDoCCDDSno3m0OqXA&usqp=CAU',
        'Time to clown around!'),
       ('c87da799-8df1-4e93-b377-84ae63656424', 'DoodleBob', 'SquarePants', 'Doodle',
        'https://media.tenor.com/br1mncjVULUAAAAe/doodlebob-spongebob.png', 'Me want to draw!'),
       ('f45000b3-3391-4938-91b2-3c1eebdbb606', 'The', 'Dirty Bubble', 'Villain',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/720f5140-2ddc-43bf-ae43-94e897a134cc/dgnh1ri-77723d8c-08ba-461e-9a29-e0166cbc3c39.png/v1/fill/w_1280,h_1281/dirty_bubble_by_chanyhuman_dgnh1ri-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTI4MSIsInBhdGgiOiJcL2ZcLzcyMGY1MTQwLTJkZGMtNDNiZi1hZTQzLTk0ZTg5N2ExMzRjY1wvZGduaDFyaS03NzcyM2Q4Yy0wOGJhLTQ2MWUtOWEyOS1lMDE2NmNiYzNjMzkucG5nIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.G95qHmRVGy5C1aQ4GXY5EergJyX-zArKoothyb3dYCk', 'I’m gonna pop you!');



