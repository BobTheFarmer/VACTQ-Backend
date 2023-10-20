""" database dependencies to support sqliteDB examples """
from random import randrange
from datetime import date
import os, base64
import json

from __init__ import app, db


''' Tutorial: https://www.sqlalchemy.org/library.html#tutorials, try to get into Python shell and follow along '''

class Player(db.Model):
    __tablename__ = 'players'  # table name is plural, class name is singular

    # Define the Player schema with "vars" from object
    id = db.Column(db.Integer, primary_key=True)
    _name = db.Column(db.String(255), unique=False, nullable=False)
    _uid = db.Column(db.String(255), unique=True, nullable=False)
    _distance = db.Column(db.String(255), unique=False, nullable=False)

    # constructor of a Player object, initializes the instance variables within object (self)
    def __init__(self, name, uid, distance):
        self._name = name    # variables with self prefix become part of the object, 
        self._uid = uid
        self._distance = distance

    # a name getter method, extracts name from object
    @property
    def name(self):
        return self._name
    
    # a setter function, allows name to be updated after initial object creation
    @name.setter
    def name(self, name):
        self._name = name
    
    # a getter method, extracts email from object
    @property
    def uid(self):
        return self._uid
    
    # a setter function, allows name to be updated after initial object creation
    @uid.setter
    def uid(self, uid):
        self._uid = uid
        
    # check if uid parameter matches user id in object, return boolean
    def is_uid(self, uid):
        return self._uid == uid
    
    @property
    def distance(self):
        return self._distance

    @distance.setter
    def distance(self, distance):
        self._distance = distance
    
    
    # output content using str(object) in human readable form, uses getter
    # output content using json dumps, this is ready for API response
    def __str__(self):
        return json.dumps(self.read())

    # CRUD create/add a new record to the table
    # returns self or None on error
    def create(self):
        try:
            # creates a player object from Player(db.Model) class, passes initializers
            db.session.add(self)  # add prepares to persist person object to Users table
            db.session.commit()  # SqlAlchemy "unit of work pattern" requires a manual commit
            return self
        except IntegrityError:
            db.session.remove()
            return None

    # CRUD read converts self to dictionary
    # returns dictionary
    def read(self):
        return {
            "id": self.id,
            "name": self.name,
            "uid": self.uid,
            "distance": self.distance
        }

    # CRUD update: updates name, uid, password, tokens
    # returns self
    def update(self, dictionary):
        """only updates values in dictionary with length"""
        for key in dictionary:
            if key == "name":
                self.name = dictionary[key]
            if key == "uid":
                self.uid = dictionary[key]
            if key == "distance":
                self.distance = dictionary[key]
        db.session.commit()
        return self

    # CRUD delete: remove self
    # return self
    def delete(self):
        player = self
        db.session.delete(self)
        db.session.commit()
        return player


"""Database Creation and Testing """


# Builds working data for testing
def initPlayers():
    with app.app_context():
        """Create database and tables"""
        db.create_all()
        """Tester records for table"""
        players = [
            Player(name='Azeem Khan', uid='azeemK', distance=45),
            Player(name='Ahad Biabani', uid='ahadB', distance=41),
            Player(name='Akshat Parikh', uid='akshatP', distance=40),
            Player(name='Josh Williams', uid='joshW', distance=38)
        ]

        """Builds sample user/note(s) data"""
        for player in players:
            try:
                player.create()
            except IntegrityError:
                '''fails with bad or duplicate data'''
                db.session.remove()
                print(f"Records exist, duplicate email, or error: {player.uid}")