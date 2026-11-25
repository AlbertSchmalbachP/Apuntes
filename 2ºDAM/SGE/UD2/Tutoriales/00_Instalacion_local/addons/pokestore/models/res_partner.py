from Odoo import models, Model, fields

class ResPartner(models.Model):
    _inherit = "res.partner"
    codigo_coleccionista = fields.Char(string="Codigo de coleccionista", required=True)
    pokemon_favorito = fields.Char(string="Pokemón favorito", required=True)
    nivel_coleccionista = fields.Char(string="Nivel de coleccionista", required=True)