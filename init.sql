CREATE TABLE characters
(
    id         TEXT PRIMARY KEY,
    firstname  TEXT NOT NULL,
    lastname   TEXT NOT NULL,
    occupation TEXT,
    motto      TEXT,
    imageUrl   TEXT
);

CREATE TABLE locations
(
    id          TEXT PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    owner       TEXT,
    funFact     TEXT,
    imageUrl    TEXT,
    address     TEXT
);

CREATE TABLE quiz
(
    id       TEXT PRIMARY KEY,
    question TEXT NOT NULL,
    answer   TEXT
);

CREATE TABLE quiz_answer_options
(
    quiz_id       TEXT NOT NULL,
    answer_option TEXT NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz (id) ON DELETE CASCADE,
    PRIMARY KEY (quiz_id, answer_option)
);


INSERT INTO characters (id, firstname, lastname, occupation, imageUrl, motto)
VALUES ('b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3', 'SpongeBob', 'SquarePants', 'Fry Cook',
        'https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/SpongeBob_SquarePants_character.svg/440px-SpongeBob_SquarePants_character.svg.png',
        'I’m ready!'),
       ('b0d4890b-7ff3-4f00-b34a-230dc5b94de5', 'Patrick', 'Star', 'Unemployed',
        'https://upload.wikimedia.org/wikipedia/en/thumb/3/33/Patrick_Star.svg/440px-Patrick_Star.svg.png',
        'Is mayonnaise an instrument?'),
       ('b9f1e582-6b4b-4e56-a509-d545e6c8a81a', 'Squidward', 'Tentacles', 'Cashier',
        'https://upload.wikimedia.org/wikipedia/en/thumb/7/79/Squidward_Tentacles_%28fair_use%29.svg/300px-Squidward_Tentacles_%28fair_use%29.svg.png',
        'I hate everyone.'),
       ('cbe4b2d8-e9c0-4d85-b2d1-b8a76d2a1155', 'Mr.', 'Krabs', 'Restaurant Owner',
        'https://upload.wikimedia.org/wikipedia/en/thumb/f/f8/Mr._Krabs.svg/440px-Mr._Krabs.svg.png',
        'Money, money, money!'),
       ('f48d6f7c-5090-4d9e-9f2c-6c1b5c305b46', 'Sandy', 'Cheeks', 'Scientist',
        'https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Sandy_Cheeks.svg/440px-Sandy_Cheeks.svg.png',
        'Texas is a state of mind!'),
       ('8e3d4c5e-1a2c-4267-bc43-0b2b52d897e0', 'Gary', 'The Snail', 'Pet',
        'https://youtooz.com/cdn/shop/products/sb-stickie-gary_501x486trim_min-2tll.png?v=1671060021', 'Meow!'),
       ('c63f7c4b-e4ab-4b53-a8f8-f4e59d84b8e2', 'Mrs.', 'Puff', 'Boating School Teacher',
        'https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Mrs._Puff.svg/640px-Mrs._Puff.svg.png',
        'You’re going to kill me!'),
       ('1a9d9c79-d7c7-4c04-8dc8-79b84d9d69f4', 'Larry', 'The Lobster', 'Lifeguard',
        'https://i.redd.it/good-ole-larry-the-lobster-v0-151ufy3z9ktd1.jpg?width=1230&format=pjpg&auto=webp&s=172ff45eed4d3a3846799fdaf468f8a937b38cd4',
        'Let’s get buff!'),
       ('e2e7dff2-9a6e-45f1-b2b1-5c0d4c3e7d82', 'Bubble', 'Bass', 'Food Critic',
        'https://youtooz.com/cdn/shop/files/38u7n1u5h1.png?v=1726153323',
        'I’m not a cook!'),
       ('7c8b1ee7-fc31-4b38-bf8a-91d2548be8b4', 'Karen', 'Plankton', 'Computer',
        'https://i.pinimg.com/564x/f0/e2/3e/f0e23e83f07e9da8f8ded461b4284504.jpg',
        'I’m not just a computer, I’m a lifestyle!'),
       ('c5c7fc15-3829-4e86-84c4-dae7fa923e69', 'Pearl', 'Krabs', 'Teenager',
        'https://lh5.googleusercontent.com/proxy/csbcxjw1OZHDR8h-CKFDPsdRjTs5GbasTImWFOCMjLUkmcLtyBCymCPALSODEkMjQkNKCIXwpH8ZsJoVaVvqwbZCQfXx_NkO7q1KpK2VnSAP47M',
        'Like, whatever!'),
       ('8d063f68-e826-478f-95b3-0eb2e1d08109', 'Sheldon', 'Plankton', 'Inventor',
        'https://ih1.redbubble.net/image.3710449734.8112/raf,750x1000,075,t,FFFFFF:97ab1c12de.jpg',
        'I’m a genius!'),
       ('239f2e80-f3e0-45af-89c1-61b23a6f50ef', 'Mermaid', 'Man', 'Hero',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/d4abc94a-f39d-409f-8ae1-4f8a1e5b0e36/dfze1uf-77e9443f-5242-4f9b-8720-73ee267dd571.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2Q0YWJjOTRhLWYzOWQtNDA5Zi04YWUxLTRmOGExZTViMGUzNlwvZGZ6ZTF1Zi03N2U5NDQzZi01MjQyLTRmOWItODcyMC03M2VlMjY3ZGQ1NzEucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.fuWL-DKcItaYALtM8s-BDcQ0e7CJlJeeQqxut53Jfb4',
        'I’m here to save the day!'),
       ('3b0d31be-d3af-4096-b46e-e8d813e52c41', 'The', 'Flying Dutchman', 'Ghost',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/1b82ba2b-aff7-44e6-9afe-a57a5c42014d/dgz7ekj-913ca7fc-887c-49b5-aeb2-312bbd8f7aa4.png/v1/fill/w_1280,h_1028/flying_dutchman_render_by_kingevan210_dgz7ekj-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyOCIsInBhdGgiOiJcL2ZcLzFiODJiYTJiLWFmZjctNDRlNi05YWZlLWE1N2E1YzQyMDE0ZFwvZGd6N2Vrai05MTNjYTdmYy04ODdjLTQ5YjUtYWViMi0zMTJiYmQ4ZjdhYTQucG5nIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.jEUCk767fFjcOpKMcSU7hclaSjzqPFsXCNDULPZNZgY',
        'Arrr, I be the Flying Dutchman!'),
       ('c87da799-8df1-4e93-b377-84ae63656424', 'DoodleBob', 'SquarePants', 'Doodle',
        'https://media.tenor.com/br1mncjVULUAAAAe/doodlebob-spongebob.png', 'Me want to draw!'),
       ('f45000b3-3391-4938-91b2-3c1eebdbb606', 'The', 'Dirty Bubble', 'Villain',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/720f5140-2ddc-43bf-ae43-94e897a134cc/dgnh1ri-77723d8c-08ba-461e-9a29-e0166cbc3c39.png/v1/fill/w_1280,h_1281/dirty_bubble_by_chanyhuman_dgnh1ri-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTI4MSIsInBhdGgiOiJcL2ZcLzcyMGY1MTQwLTJkZGMtNDNiZi1hZTQzLTk0ZTg5N2ExMzRjY1wvZGduaDFyaS03NzcyM2Q4Yy0wOGJhLTQ2MWUtOWEyOS1lMDE2NmNiYzNjMzkucG5nIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.G95qHmRVGy5C1aQ4GXY5EergJyX-zArKoothyb3dYCk',
        'I’m gonna pop you!'),
       ('1df8bbce-6f91-4c49-95f9-4fdc4c732f76', 'Man', 'Ray', 'Villain',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLeBM4Js1hNL3CvLpyp3B1F6o3aal6oiXzR-mFSVUm2qd7_ygYVOUF-jnpIVEdVD1kSi8&usqp=CAU',
        'Prepare to be villainized!'),
       ('21bd6f99-4457-4ad2-99e3-46893c8ff1b4', 'Barnacle', 'Boy', 'Sidekick',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi0sSi1EEyQGG-HEjyXitQ0tmeFdO0ER5u_zbzbD12fxH1ndmMHKL6azIwK8v11rnWfxg&usqp=CAU',
        'I’m not a boy, I’m a man!'),

       ('78d1c3be-72a6-43bb-b8ff-17e73b3c34ef', 'Patchy', 'The Pirate', 'Pirate/Host',
        'https://i.ibb.co/2dmfgLs/pirate-ok.png', 'Ahoy, mateys!'),
       ('e7f86d45-94d5-43b4-a178-4f544f0e0bb6', 'Potty', 'The Parrot', 'Parrot/Sidekick',
        'https://i.ibb.co/QPrRyFx/parrot-ok.png', 'Squawk!'),
       ('e23b120e-d274-4e89-bbc9-836ee033ee8e', 'Old Man', 'Jenkins', 'Retired',
        'https://i.redd.it/who-is-old-man-jenkins-v0-kqmnxb2yw6zc1.jpg?width=224&format=pjpg&auto=webp&s=82d9de48eed4608b46edc6f163eaa9477fa7e7ef',
        'Back in my day...'),
       ('7f19f9a5-8f39-4652-a8f2-71b18c39f392', 'Fred', 'The Fish', 'Civilian',
        'https://i.ibb.co/JzXcWs9/fred.png', 'My leg!'),
       ('46a93737-51e9-4c6a-a06f-56cb1f48f2e4', 'Squilliam', 'Fancyson', 'Rival',
        'https://i.ibb.co/TWymxpZ/squilliam-ok.png', 'I’m rich!'),
       ('d843f58f-efaa-4086-b3ac-96c48e8cbe42', 'Perch', 'Perkins', 'News Reporter',
        'https://i.ibb.co/wsYjwbC/perch-ok.png', 'This just in...'),
       ('3b5a9c8e-0876-4031-804b-792b376ce3a3', 'Nat', 'Peterson', 'Background Fish',
        'https://www.inspireuplift.com/resizer/?image=https://cdn.inspireuplift.com/uploads/images/seller_products/31765/1702980704_NatPeterson-Spongebobfish.png&width=600&height=600&quality=90&format=auto&fit=pad',
        'Whoa, that’s crazy!'),
       ('f0ca6dff-29e1-4960-8fd4-3f4e148e3205', 'Harold', 'SquarePants', 'SpongeBob’s Dad',
        'https://i.ibb.co/xGWcVQY/dad.png', 'Son, we’re proud of you.'),
       ('3caa4b1e-4320-4ef8-8618-9e37e5cfc17f', 'Margaret', 'SquarePants', 'SpongeBob’s Mom',
        'https://i.ibb.co/dm0YkG9/mom-and-dad-copy.png', 'Be careful, SpongeBob.'),
       ('cf2df28e-e21a-4f52-9d30-705531cf86f2', 'King', 'Neptune', 'God of the Sea',
        'https://i.ibb.co/vk8cM1r/king-neptune-ok.png', 'Bow to your king!'),
       ('ba4e7cda-22af-40a5-8cf4-8740123d88b0', 'The', 'Tattletale Strangler', 'Villain',
        'https://i.ibb.co/zRkp3jX/Screenshot-2024-10-15-at-19-02-37.png',
        'You’ll never tattletale again!'),
       ('ac908d14-e6cc-4e24-8a8b-cb8a08de9fc5', 'Flatts', 'The Flounder', 'Bully',
        'https://i.ibb.co/yykCJQc/Flatts-The-Flounder.png', 'I’m gonna kick your butt!'),
       ('b0f71e13-9d2b-453e-a0e1-02c462a61558', 'Don', 'The Whale', 'Whale',
        'https://i.ibb.co/9bdXd3w/don-ok.png', 'I lift!'),
       ('11958a26-815f-48e5-8db2-e1b5e98e64d2', 'Dr.', 'Gill Gilliam', 'Doctor',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLmrSvA59B1WvkW8sc-bi4a5581NSQvWY0kAJtBPhd-uT-zvoV0metmS8N4aSc_NH2dwg&usqp=CAU',
        'Time for your check-up.'),
       ('7e7e23bb-d6b4-49a7-9bfb-4c998e7a5218', 'Dennis', '', 'Bounty Hunter',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/1426e3b7-ac36-4883-bd01-2847d4ae0525/dfmxsww-4154178b-8250-4d8d-a0e4-67298b2717cb.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzE0MjZlM2I3LWFjMzYtNDg4My1iZDAxLTI4NDdkNGFlMDUyNVwvZGZteHN3dy00MTU0MTc4Yi04MjUwLTRkOGQtYTBlNC02NzI5OGIyNzE3Y2IucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.wumJzG2SlujJsmiCSoDo7E1wFN-Wvp5vutcA1dC0AZY',
        'I’m here for you, SpongeBob!')
;

INSERT INTO locations (id, name, owner, funFact, description, imageUrl, address)
VALUES ('b0f71e13-9d2b-453e-a0e1-02c462a61558', 'Spongebob house', 'SpongeBob SquarePants',
        'SpongeBob lives in a pineapple under the sea.', 'The pineapple-shaped house of SpongeBob SquarePants.',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/eacf3422-c1a2-403d-a730-605b2abea60f/d694muy-60f62399-7876-4dbd-9d44-cd56523bc469.png/v1/fill/w_1024,h_769,q_80,strp/spongebob_s_house_by_cartoonkal_d694muy-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NzY5IiwicGF0aCI6IlwvZlwvZWFjZjM0MjItYzFhMi00MDNkLWE3MzAtNjA1YjJhYmVhNjBmXC9kNjk0bXV5LTYwZjYyMzk5LTc4NzYtNGRiZC05ZDQ0LWNkNTY1MjNiYzQ2OS5wbmciLCJ3aWR0aCI6Ijw9MTAyNCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.-57f4hzc1cRmmMEZp5PLph-376Xi7PKYFxg-sv0-SD4',
        '124 Conch Street'),

       ('2b1f51f4-58c7-4b73-9800-59de9e0d9d12', 'Squidward house', 'Squidward Tentacles',
        'Squidward house is shaped like an Easter Island head.',
        'The stone Tiki-head house where Squidward Tentacles lives.',
        'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/380dbd01-38ee-4146-93df-31ce051f4b83/df7dnvu-4e54dba3-ad6b-463b-8aa5-e3cc362afedd.png/v1/fill/w_1280,h_1456,q_80,strp/_spongebob_squarepants__squidward_s_house_by_spongedrew250_df7dnvu-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzM4MGRiZDAxLTM4ZWUtNDE0Ni05M2RmLTMxY2UwNTFmNGI4M1wvZGY3ZG52dS00ZTU0ZGJhMy1hZDZiLTQ2M2ItOGFhNS1lM2NjMzYyYWZlZGQucG5nIiwiaGVpZ2h0IjoiPD0xNDU2Iiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uud2F0ZXJtYXJrIl0sIndtayI6eyJwYXRoIjoiXC93bVwvMzgwZGJkMDEtMzhlZS00MTQ2LTkzZGYtMzFjZTA1MWY0YjgzXC9zcG9uZ2VkcmV3MjUwLTQucG5nIiwib3BhY2l0eSI6OTUsInByb3BvcnRpb25zIjowLjQ1LCJncmF2aXR5IjoiY2VudGVyIn19.EBJztJrDM3YK6AjY6ep3Ky75VKwiKwJGNsiKugHLW1Y',
        '122 Conch Street'),

       ('3d6c22be-f490-4016-b235-7e892d217ab6', 'Patrick house', 'Patrick Star',
        'Patrick house is a rock that he lives under.', 'The house of Patrick Star, which is just a rock.',
        'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/0fbb05107478815.5fa8477153d1d.jpg',
        '120 Conch Street'),

       ('4d88d25a-5b41-4a68-a8d7-d6ab3a2355a1', 'Chum bucket', 'Plankton',
        'Plankton tries to steal the Krabby Patty secret formula.', 'The fast food restaurant owned by Plankton.',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXea7d23WI0J-Wu6rHCMwF1g8Wr7JQ3n7lFg&s',
        '2230 Bikini Bottom Ave'),

       ('5d34f926-fb2c-4453-bd16-bf8787cfc283', 'Krusty krab', 'Mr. Krabs',
        'The Krabby Patty is the most popular food at the Krusty Krab.',
        'The famous fast food restaurant owned by Mr. Krabs.',
        'https://www.wikihow.com/images/a/a7/Draw-the-Krusty-Krab-Step-34.jpg', '831 Bottom Feeder Lane'),

       ('6e2333b9-c3e7-4a41-85c8-88c44c2ea90b', 'The salty spitoon', 'None',
        'The Salty Spitoon is a tough club for tough fish.', 'A club for the toughest fish in Bikini Bottom.',
        'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgV4opNgXkJW3vJ1no6nvp8SCwtJuisrOjeU27QfOlESq9x-VwalxQZ1Is9wmfPClELNca7B5javckAuZodxRq4lzPW65SzPq7Kh_QVPWadFpTHSoYlgL9Z2DG8pcDYBFko1NrpcbdvC1_qTeMQABDEmPZdPL0gE8O-qsM_Ob93tZtSc0Fqyw/s1420/No_Weenies_Allowed_043.webp',
        'Rough and Tough Blvd'),

       ('7b1734bb-540d-40c8-86da-41a5aeaba104', 'Glove world', 'None', 'Glove World is an amusement park.',
        'An amusement park full of fun rides and games.',
        'https://preview.redd.it/rgckeidzazo51.png?width=1080&crop=smart&auto=webp&s=29d12b3d9226b9ed0f5a9996978c2107c0a16ef3',
        'Glove Street'),

       ('8e54b47e-1c41-4e6b-872e-9bfb7cddc47b', 'Dutchman cave', 'The Flying Dutchman',
        'The Dutchman ship haunts the sea.', 'The lair of the ghost pirate, The Flying Dutchman.',
        'https://upload.wikimedia.org/wikipedia/id/a/a7/Legends_of_Bikini_Bottom_promo_art.jpg', 'Haunted Hill'),

       ('9f27cd74-81cb-49e3-b4e2-6f7a7d5f9e8a', 'Sandies house', 'Sandy Cheeks',
        'Sandy house is a glass dome because she a land mammal.',
        'A glass dome where Sandy Cheeks lives to breathe air.',
        'https://media-s3-us-east-1.ceros.com/editorial-content/images/2021/02/03/33f5d793f462452a6bed22c68c2dcd45/sandys.png',
        'Treedome 101'),

       ('a12d5129-01c1-4b5b-a22b-c412aba8b545', 'Shady shoals', 'Mermaid Man',
        'Shady Shoals is a retirement home where Mermaid Man and Barnacle Boy live.',
        'A retirement home where superheroes Mermaid Man and Barnacle Boy reside.',
        'https://cdn.mobygames.com/c809a21a-ac17-11ed-9eb0-02420a000136.webp', 'Elderly Reef St'),

       ('b37c2829-3adf-44d7-bfc6-d09b9311e726', 'Bank', 'None',
        'The Bank is where Bikini Bottom citizens keep their money.', 'The central bank of Bikini Bottom.',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ4i7msgRonhyHav3D4uusO5HT4PlXmM3LuA&s',
        'Bank Ave 450'),

       ('c497927b-5fb7-4829-87da-d0ed098ffbb2', 'Puffs boating school', 'Mrs. Puff',
        'Mrs. Puff teaches SpongeBob how to drive.', 'Mrs. Puff driving school where SpongeBob is a student.',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3OrmkO0ZomtFD-n8uJCPxXfO8uSza4dZDTbN6WFZPEJQj8ZoHm8HfWWFn3wHHNe_n74M&usqp=CAU',
        'School Blvd 32'),

       ('d516a538-f0a7-4298-a6fe-fadac826be6a', 'Mussel beach', 'None', 'Mussel Beach is a popular vacation spot.',
        'A relaxing beach with mussels and sunbathing Bikini Bottomites.',
        'https://lh3.googleusercontent.com/proxy/qVu2dOcp8EgcGeMDW9qD2tLqMSBP2d_YbBM3w4X2oV3clqumEBpjv9_5C5l451cGKgQ8miG1lnaRKsQCetin8HY7hh3hIHPrRFVhRhMN',
        'Mussel Ave 900');

INSERT INTO quiz (id, question, answer)
VALUES ('1', 'What is SpongeBob job at the Krusty Krab?', 'Fry Cook'),
       ('2', 'What is the name of SpongeBob pet snail?', 'Gary'),
       ('3', 'Who is SpongeBob best friend?', 'Patrick Star'),
       ('4', 'What is the name of the town where SpongeBob lives?', 'Bikini Bottom'),
       ('5', 'What is the Krusty Krab secret ingredient?', 'Krabby Patty Secret Formula'),
       ('6', 'Who is the owner of the Krusty Krab?', 'Mr. Krabs'),
       ('7', 'What is Squidward profession?', 'Cashier at the Krusty Krab'),
       ('8', 'What does SpongeBob use to catch jellyfish?', 'A jellyfishing net'),
       ('9', 'What instrument does Squidward play?', 'Clarinet'),
       ('10', 'What is the name of SpongeBob boating school teacher?', 'Mrs. Puff'),
       ('11', 'What type of creature is Plankton?', 'Microbe/Plankton'),
       ('12', 'What is SpongeBob favorite pastime?', 'Blowing bubbles'),
       ('14', 'What do SpongeBob and Patrick use to create their own superhero identities?',
        'The "Super" and "Electric" costumes'),
       ('15', 'What is the name of the infamous sea monster in the series?', 'The Alaskan Bull Worm'),
       ('16', 'What does Mr. Krabs love more than anything?', 'Money'),
       ('17', 'What type of animal is Gary?', 'Snail'),
       ('18', 'Who often tries to steal the Krabby Patty formula?', 'Plankton'),
       ('19', 'What is the name of SpongeBob favorite restaurant, besides the Krusty Krab?',
        'The Chum Bucket (but he dislikes it)'),
       ('20', 'What does SpongeBob often say to cheer people up?', 'Im ready, Im ready, Im ready!');

INSERT INTO quiz_answer_options (quiz_id, answer_option)
VALUES ('1', 'Fry Cook'),
       ('1', 'Cashier'),
       ('1', 'Manager'),
       ('1', 'Waiter'),
       ('2', 'Gary'),
       ('2', 'Meow'),
       ('2', 'Bubbles'),
       ('2', 'Patrick'),
       ('3', 'Patrick Star'),
       ('3', 'Sandy Cheeks'),
       ('3', 'Squidward'),
       ('3', 'Mr. Krabs'),
       ('4', 'Bikini Bottom'),
       ('4', 'Atlantis'),
       ('4', 'Undersea World'),
       ('4', 'Ocean City'),
       ('5', 'Krabby Patty Secret Formula'),
       ('5', 'Chum'),
       ('5', 'Ketchup'),
       ('5', 'Pickles'),
       ('6', 'Mr. Krabs'),
       ('6', 'Squidward'),
       ('6', 'SpongeBob'),
       ('6', 'Plankton'),
       ('7', 'Cashier at the Krusty Krab'),
       ('7', 'Chef'),
       ('7', 'Lifeguard'),
       ('7', 'Gardener'),
       ('8', 'A jellyfishing net'),
       ('8', 'A bucket'),
       ('8', 'A fishing rod'),
       ('8', 'A rope'),
       ('9', 'Clarinet'),
       ('9', 'Piano'),
       ('9', 'Drums'),
       ('9', 'Guitar'),
       ('10', 'Mrs. Puff'),
       ('10', 'Mr. Krabs'),
       ('10', 'Squidward'),
       ('10', 'Sandy Cheeks'),
       ('11', 'Microbe/Plankton'),
       ('11', 'Fish'),
       ('11', 'Crab'),
       ('11', 'Shrimp'),
       ('12', 'Blowing bubbles'),
       ('12', 'Sailing'),
       ('12', 'Fishing'),
       ('12', 'Playing video games'),
       ('14', 'The "Super" and "Electric" costumes'),
       ('14', 'Capes and masks'),
       ('14', 'Dresses and shoes'),
       ('14', 'Hat and glasses'),
       ('15', 'The Alaskan Bull Worm'),
       ('15', 'The Sea Cucumber'),
       ('15', 'The Flying Dutchman'),
       ('15', 'The Loch Ness Monster'),
       ('16', 'Money'),
       ('16', 'Love'),
       ('16', 'SpongeBob'),
       ('16', 'Sandy'),
       ('17', 'Snail'),
       ('17', 'Fish'),
       ('17', 'Crab'),
       ('17', 'Octopus'),
       ('18', 'Plankton'),
       ('18', 'Sandy'),
       ('18', 'Mr. Krabs'),
       ('18', 'Squidward'),
       ('19', 'The Chum Bucket (but he dislikes it)'),
       ('19', 'The Krusty Krab'),
       ('19', 'The Sea Cucumber'),
       ('19', 'The Ice Cream Shop'),
       ('20', 'Im ready, Im ready, Im ready!'),
       ('20', 'Lets go!'),
       ('20', 'Time to party!'),
       ('20', 'Its a good day!');


