from sqlalchemy import Column, Integer, String, Boolean
from database import Base

class Sticker(Base):
    __tablename__ = "stickers"
    
    id = Column(Integer, primary_key=True, index=True)

    numero = Column(Integer)
    jogador = Column(String)
    selecao = Column(String)
    raridade = Column(String)

    tenho = Column(Boolean)
    colada = Column(Boolean)
    repetida = Column(Boolean)

