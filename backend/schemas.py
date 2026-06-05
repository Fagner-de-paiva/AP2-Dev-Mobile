from pydantic import BaseModel

class StickerCreate(BaseModel):
    numero: int
    jogador: str
    selecao: str
    raridade: str
    tenho: bool
    colada: bool
    repetida: bool
