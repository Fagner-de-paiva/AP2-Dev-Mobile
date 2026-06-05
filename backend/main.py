from fastapi import FastAPI
from sqlalchemy.orm import Session

from database import engine, Base, SessionLocal
from models import Sticker
from schemas import StickerCreate

app = FastAPI()

Base.metadata.create_all(bind=engine)

@app.get("/")
def home():
    return {"message": "API do StickerTrack funcionando"}

@app.post("/stickers")
def create_sticker(sticker: StickerCreate):

    db: Session = SessionLocal()
    novo_sticker = Sticker(
        numero=sticker.numero,
        jogador=sticker.jogador,
        selecao=sticker.selecao,
        raridade=sticker.raridade,
        tenho=sticker.tenho,
        colada=sticker.colada,
        repetida=sticker.repetida
    )

    db.add(novo_sticker)
    db.commit()
    db.refresh(novo_sticker)
    return novo_sticker

@app.get("/stickers")
def get_stickers():

    db: Session = SessionLocal()

    stickers = db.query(Sticker).all()

    return stickers
