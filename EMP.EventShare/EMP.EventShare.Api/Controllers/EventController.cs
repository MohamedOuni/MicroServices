
using EMP.EventShare.Api.Entite;
using EMP.EventShare.Api.Services;
using Microsoft.AspNetCore.Mvc;

namespace EMP.EventShare.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EventController : ControllerBase
    {
        private readonly EventService evenementServices;

        public EventController(EventService evenementServices)
        {
            this.evenementServices = evenementServices;
        }

        [HttpGet("getAll")]
        public IActionResult Get()
        {
            var evenements = evenementServices.GetEvenements();
            return Ok(evenements);
        }

        [HttpGet("getEvent/{id}")]
        public IActionResult Get(int id)
        {
            var evenement = evenementServices.GetEvenementById(id);

            if (evenement == null)
            {
                return NotFound();
            }

            return Ok(evenement);
        }

        [HttpPost("ajouter")]
        public IActionResult Post([FromBody] Event evenement)
        {
            evenementServices.CreateEvenement(evenement);
            return CreatedAtAction(nameof(Get), new { id = evenement.Id }, evenement);
        }

        [HttpPut("updateEvent/{id}")]
        public IActionResult Put(int id, [FromBody] Event updatedEvenement)
        {
            evenementServices.UpdateEvenement(id, updatedEvenement);
            return NoContent();
        }

        [HttpDelete("deleteEvent/{id}")]
        public IActionResult Delete(int id)
        {
            evenementServices.DeleteEvenement(id);
            return NoContent();
        }
    }
}
